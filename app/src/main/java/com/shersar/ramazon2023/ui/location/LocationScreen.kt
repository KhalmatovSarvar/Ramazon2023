package com.shersar.ramazon2023.ui.location

import android.Manifest
import android.content.Context
import android.content.IntentSender
import android.content.SharedPreferences
import android.content.*
import android.net.ConnectivityManager
import androidx.appcompat.app.AlertDialog
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.location.Geocoder
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.BottomSheetAdapter
import com.shersar.ramazon2023.databinding.ScreenLocationBinding
import com.shersar.ramazon2023.model.Bottomsheet
import com.shersar.ramazon2023.model.Location
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.utils.navigateSafely
import com.shersar.ramazon2023.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint
import viewBinding
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class LocationScreen : Fragment(R.layout.screen_location) {
    private lateinit var preferences: SharedPreferences.Editor

    private val locationViewModel: LocationViewModel by viewModels()
    private lateinit var adapter: BottomSheetAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var connectivityReceiver: BroadcastReceiver
    lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var list = arrayListOf<Bottomsheet>()
    private var data =
        arrayOf(
            Location("Toshkent", 41.2842, 69.2441),
            Location("Andijon", 40.7814, 72.3578),
            Location("Namangan", 41.0522, 71.6465),
            Location("Farg'ona", 40.3694, 71.7989),
            Location("Jizzax", 40.1214, 67.9031),
            Location("Sirdaryo", 40.8346, 68.6783),
            Location("Samarqand", 39.7483, 66.8888),
            Location("Qashqadaryo", 38.8555, 65.7783),
            Location("Surxondaryo", 37.2880, 67.3164),
            Location("Navoiy", 40.1012, 65.3885),
            Location("Xiva", 41.3906, 60.3481),
            Location("Urganch", 41.5352, 60.6313),
            Location("Buxoro", 39.7669, 64.4587)
        )
    private val binding by viewBinding { ScreenLocationBinding.bind(it) }
    private lateinit var bottomSheet1: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationViewModel.getAllPrayerTimesFromDb()
        // Register broadcast receiver to listen for network changes
        connectivityReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                checkInternetConnection()
            }
        }
        requireContext().registerReceiver(connectivityReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }
    override fun onDestroy() {
        super.onDestroy()
        requireContext().unregisterReceiver(connectivityReceiver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkInternetConnection()
        initView()
        setUpObservers()
        preferences = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE).edit()}

    private fun checkInternetConnection() {
        val connectivityManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            // Internet connection is available
            // Your code to handle the internet connection
        } else {
            // Internet connection is not available
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Internet aloqasi mavjud emas!")
            builder.setMessage("Internetga ulanish yo'q, aloqa holatini tekshiring.")
            builder.setPositiveButton("OK") { dialog, which ->
                checkInternetConnection() // Recursively check for internet connection
            }
            builder.setCancelable(false) // Prevent dialog from being dismissed
            builder.show()
        }



    private fun initView() {

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())

        recyclerView = binding.rv
        adapter = BottomSheetAdapter(getData())
        adapter.onClick = {
            preferences.putString("location", it.address)
            preferences.apply()
            openHomePage(it.lat, it.long)
        }

        recyclerView.adapter = adapter
        var count = 1

        binding.llChoose.setOnClickListener {
            if (count % 2 == 1) {
                binding.ivDownArrow
                    .setImageResource(R.drawable.ic_arrow_down)
                binding.rv.visibility = View.VISIBLE
                count++
            } else {
                binding.ivDownArrow
                    .setImageResource(R.drawable.ic_up_arrow)
                binding.rv.visibility = View.GONE
                count++
            }
        }

        binding.switchCompatLoc.setOnClickListener {
            if (binding.switchCompatLoc.isChecked) {

                binding.switchCompatLoc.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.background))
                binding.switchCompatLoc.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_true))
                checkLocationPermission()
            } else {
                binding.switchCompatLoc.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
                binding.switchCompatLoc.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
            }
        }

    }

    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            checkGPS()
            binding.loading.visibility=View.VISIBLE

        } else {
            binding.switchCompatLoc.isChecked = false
            binding.switchCompatLoc.thumbTintList =
                ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
            binding.switchCompatLoc.trackTintList =
                ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100

            )
        }
    }

    private fun checkGPS() {
        locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 2000

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        builder.setAlwaysShow(true)

        val result = LocationServices.getSettingsClient(
            requireContext().applicationContext
        ).checkLocationSettings(builder.build())
        result.addOnCompleteListener { task ->
            try {
                val response = task.getResult(
                    ApiException::class.java
                )
                getUserLocation()
            } catch (e: ApiException) {
                e.printStackTrace()
                when (e.statusCode) {
                    LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> try {
                        val resolveApiException = e as ResolvableApiException
                        resolveApiException.startResolutionForResult(requireActivity(), 200)

                    } catch (sendIntentException: IntentSender.SendIntentException) {
                    }
                    LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {

                    }
                }
            }
        }
    }

    private fun getUserLocation() {

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
            val location = task.getResult()
            if (location != null) {
                try {
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())

                    val address = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    val address_line = address?.get(0)?.getAddressLine(0)

                    Log.d("Address", "Addresss heree : ${address_line} - ${address?.get(0)?.locality}")

                    val address_location = address?.get(0)?.getAddressLine(0)
//                    findNavController().navigate(R.id.homeScreen)
                    // openLocation(address_location.toString())

                    preferences.putString("location", address?.get(0)?.locality)
                    preferences.apply()
                    openHomePage(location.latitude, location.longitude)
                } catch (e: IOException) {
                }
            }
        }
    }

    private fun openHomePage(lat: Double, long: Double) {
        locationViewModel.getHijriCalendar(lat, long)
    }

    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            locationViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiStateObject.SUCCESS -> {
                        // Update UI with data
                        val data = uiState.data // list of HijriCalendarResponse objects
                        Log.d("LocationScreen", "setUpObserversSuccess: ${data} ")
                        findNavController().navigateSafely(R.id.action_global_mainFlowFragment)
//                        findNavController().navigate(R.id.homeScreen)
                    }
                    is UiStateObject.ERROR -> {
                        // Handle error
                        val errorMessage = uiState.message
                        Log.d("LocationScreen", "setUpObserversError: $errorMessage ")

                    }
                    UiStateObject.LOADING -> {
                        // Show loading indicator

                    }
                    UiStateObject.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }

    }

    private fun setUpObserversDB() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            locationViewModel.prayerTimeInDB.collect { prayerTimeInDB ->
                when (prayerTimeInDB) {
                    is UiStateList.SUCCESS -> {
                        // Update UI with data
                        val data = prayerTimeInDB.data // list of HijriCalendarResponse objects
                        Log.d("LocationScreen", "setUpObserversSuccess: ${data} ")
                        if (data.isEmpty()) {
                            setUpObservers()
                        } else {
                            findNavController().navigate(R.id.homeScreen)
                        }

                    }
                    is UiStateList.ERROR -> {
                        // Handle error
                        val errorMessage = prayerTimeInDB.message
                        Log.d("LocationScreen", "setUpObserversError: $errorMessage ")

                    }
                    UiStateList.LOADING -> {
                        // Show loading indicator

                    }
                    UiStateList.EMPTY -> {
                        // Handle empty state
                        setUpObservers()
                    }
                }
            }
        }

    }

    private fun openLocation(location: String) {
        /**  binding.tvLocalation.setOnClickListener {
        if (!binding.tvLocalation.text.isEmpty()) {
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
        }
        }*/
    }

    private fun bottomSheet() {
        val bottomSheet = layoutInflater.inflate(R.layout.bottomsheet, null)
        bottomSheet1 = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        bottomSheet1.setContentView(bottomSheet)
        recyclerView = bottomSheet.findViewById(R.id.rv)
        adapter = BottomSheetAdapter(getData())
        recyclerView.adapter = adapter
        bottomSheet1.show()
        var count = 1
        bottomSheet.findViewById<LinearLayout>(R.id.choose).setOnClickListener {
            if (count % 2 == 1) {
                bottomSheet.findViewById<ImageView>(R.id.arrow_down)
                    .setImageResource(R.drawable.ic_up_arrow)
                bottomSheet.findViewById<RecyclerView>(R.id.rv).visibility = View.VISIBLE
                count++
            } else {
                bottomSheet.findViewById<ImageView>(R.id.arrow_down)
                    .setImageResource(R.drawable.ic_arrow_down)
                bottomSheet.findViewById<RecyclerView>(R.id.rv).visibility = View.GONE
                count++
            }
        }
    }

    private fun getData(): ArrayList<Bottomsheet> {
        for (i in data.indices) {
            list.add(Bottomsheet(data[i], false))
        }
        return list
    }
}
