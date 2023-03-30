package com.shersar.ramazon2023.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.FragmentSplashBinding
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.utils.activityNavController
import com.shersar.ramazon2023.utils.navigateSafely
import com.shersar.ramazon2023.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import viewBinding

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()
    private val binding by viewBinding { FragmentSplashBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel.getAllPrayerTimesFromDb()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
    }


    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            splashViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiStateList.SUCCESS -> {
                        // Update UI with data
                        val data = uiState.data // list of HijriCalendarResponse objects
                        Log.d("SplashScreen", "setUpObserversSuccess: ${data} ")
                        if (data.isEmpty()){
                            activityNavController().navigateSafely(R.id.action_global_locationFragment)
                        } else{
                            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
                        }
                        Log.d("HOMESCREEN", "setUpObserversSuccess: $ ")

                    }
                    is UiStateList.ERROR -> {
                        // Handle error
                        val errorMessage = uiState.message
                        Log.d("HOMESCREEN", "setUpObserversError: $errorMessage ")
//                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.LOADING -> {
                        // Show loading indicator
//                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }


    }
}