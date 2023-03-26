package com.shersar.ramazon2023.utils

import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.flow.MutableStateFlow

class LocationService(private val context: Context) {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    suspend fun getCurrentLocation(): MutableStateFlow<Location?> {
        val locationFlow = MutableStateFlow<Location?>(null)

        try {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                locationFlow.value = location
            }.addOnFailureListener { exception ->
                locationFlow.value = null
            }
        } catch (e: SecurityException) {
            locationFlow.value = null
        }

        return locationFlow
    }
}
