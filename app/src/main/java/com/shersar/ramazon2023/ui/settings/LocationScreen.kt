package com.shersar.ramazon2023.ui.settings


import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenLocationBinding
import viewBinding
import java.io.IOException
import java.util.*

class LocationScreen : Fragment(R.layout.screen_location) {

    private val binding by viewBinding { ScreenLocationBinding.bind(it) }
    lateinit var locationRequest: LocationRequest
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        binding.btnLocation.setOnClickListener {
            checkLocationPermission()
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
                    binding.tvLocalation.setText(address_line)
                    val address_location = address?.get(0)?.getAddressLine(0)
                    findNavController().navigate(R.id.homeScreen)
                    // openLocation(address_location.toString())
                } catch (e: IOException) {
                }
            }
        }
    }

    private fun openLocation(location: String) {
        binding.tvLocalation.setOnClickListener {
            if (!binding.tvLocalation.text.isEmpty()) {
                val uri = Uri.parse("geo:0,0?q=$location")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            }
        }
    }
}