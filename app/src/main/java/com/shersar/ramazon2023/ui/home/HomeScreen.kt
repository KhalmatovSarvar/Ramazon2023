package com.shersar.ramazon2023.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import viewBinding

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private val binding by viewBinding { ScreenHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()
//        homeViewModel.getHijriCalendar(2023, 3, 41.311081, 69.240562)

        homeViewModel.startCountdown()
        homeViewModel.getAllPrayerTimesFromDb()
//        setUpObservers()
    }



    private fun initView() {
        binding.apply {
            flOgizYopish.setOnClickListener {
                if (tvOgizYopishArab.visibility != View.VISIBLE) {
                    tvOgizYopishArab.visibility = View.VISIBLE
                } else {
                    tvOgizYopishArab.visibility = View.GONE
                }
            }
            flOgizOchish.setOnClickListener {
                if (tvOgizOchishArab.visibility != View.VISIBLE) {
                    tvOgizOchishArab.visibility = View.VISIBLE
                } else {
                    tvOgizOchishArab.visibility = View.GONE
                }
            }
            llLocation.setOnClickListener {
                findNavController().navigate(R.id.action_homeScreen_to_locationScreen)
            }
        }
    }


    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            homeViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiStateObject.SUCCESS -> {
                        // Update UI with data
                        val data = uiState.data // list of HijriCalendarResponse objects
                        Log.d("HOMESCREEN", "setUpObserversSuccess: ${data.data?.size.toString()} ")
                        Toast.makeText(requireContext(), data.data?.size.toString(), Toast.LENGTH_SHORT).show()

                    }
                    is UiStateObject.ERROR -> {
                        // Handle error
                        val errorMessage = uiState.message
                        Log.d("HOMESCREEN", "setUpObserversError: $errorMessage ")
                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.LOADING -> {
                        // Show loading indicator
                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }


        lifecycleScope.launch {
            homeViewModel.currentTime.collect { time ->
                binding.tvDayLeft.text = time // update a TextView with the current time
            }
        }

    }
}
