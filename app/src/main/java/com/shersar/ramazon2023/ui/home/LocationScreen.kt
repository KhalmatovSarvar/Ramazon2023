package com.shersar.ramazon2023.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.databinding.ScreenLocationBinding
import com.shersar.ramazon2023.viewmodel.HomeViewModel
import com.shersar.ramazon2023.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint
import viewBinding


@AndroidEntryPoint
class LocationScreen : Fragment(R.layout.screen_location) {

    private val locationViewModel: LocationViewModel by viewModels()
    private val binding by viewBinding { ScreenLocationBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {


//        binding.btnLocation.setOnClickListener {
//
//
//            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
//                locationViewModel.locationFlow.collect { location ->
//                    // Handle the location result here
//                    if (location != null) {
//
//                        Toast.makeText(
//                            requireContext(),
//                            "${location.longitude}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        Log.d("locationFind", "initView: ${location.longitude.dec()} ")
//                        // Do something with the location
//                    } else {
//                        // Handle the case where location is null
//                        Log.d("locationFind", "location is NULL ")
//                    }
//                }
//
//            }
//        }
    }
}