package com.shersar.ramazon2023.ui.location

import android.Manifest
import android.content.IntentSender
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.BottomSheetAdapter
import com.shersar.ramazon2023.databinding.ScreenLocationBinding
import com.shersar.ramazon2023.databinding.ScreenSettingsBinding
import com.shersar.ramazon2023.model.Bottomsheet
import viewBinding
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList


class LocationScreen : Fragment(R.layout.screen_location) {
    private lateinit var adapter: BottomSheetAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var list = arrayListOf<Bottomsheet>()
    private var data =
        arrayOf("Toshkent", "Andijon", "Namangan", "Xorazm", "Navoiy", "Bekobod", "Jizzax")
    private val binding by viewBinding { ScreenLocationBinding.bind(it) }
    private lateinit var bottomSheet1: BottomSheetDialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()


    }

    private fun initView() {

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())

        recyclerView = binding.rv
        adapter = BottomSheetAdapter(getData())
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
        } else {
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
                    //   binding.tvLocalation.setText(address_line)
                    Toast.makeText(requireContext(), "${location.latitude}", Toast.LENGTH_SHORT)
                        .show()
                    val address_location = address?.get(0)?.getAddressLine(0)
                    findNavController().navigate(R.id.homeScreen)
                    // openLocation(address_location.toString())
                } catch (e: IOException) {
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
