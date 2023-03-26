package com.shersar.ramazon2023.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import viewBinding

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private val binding by viewBinding { ScreenHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        homeViewModel.getHijriCalendar(1444, 9, 41.311081, 69.240562)
        setUpObservers()
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
        }
    }


    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            homeViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiStateList.SUCCESS -> {
                        // Update UI with data
                        val data = uiState.data // list of HijriCalendarResponse objects
                        Log.d("HOMESCREEN", "setUpObservers: ${data.size.toString()} ")
                        Toast.makeText(requireContext(), data.size.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is UiStateList.ERROR -> {
                        // Handle error
                        val errorMessage = uiState.message
                        Log.d("HOMESCREEN", "setUpObservers: $errorMessage ")
                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.LOADING -> {
                        // Show loading indicator
                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateList.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }
    }
}
