package com.shersar.ramazon2023.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getPrayerTimeByDay()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()
//        homeViewModel.getHijriCalendar(2023, 3, 41.311081, 69.240562)

//        homeViewModel.startCountdown()
//        homeViewModel.getAllPrayerTimesFromDb()
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

    @SuppressLint("SetTextI18n")
    private fun setUpTimes(day: DailyPrayerTimesEntity){
        binding.apply {
            tvDayHijriy.text = "${String.format("%02d", day.day.toInt())}.${String.format("%02d", day.monthNumber)}.${day.year}"
            tvDayQamariy.text = "${day.dayHijri} ${day.monthNameEN} ${day.yearHijri}"

            tvSaharlik.text = day.fajr.split(" ")[0]
            tvQuyosh.text = day.Sunrise.split(" ")[0]
            tvIftorlik.text = day.Sunset.split(" ")[0]

            tvFajrTime.text = day.fajr.split(" ")[0]
            tvZuhrTime.text = day.Dhuhr.split(" ")[0]
            tvAsrTime.text = day.Asr.split(" ")[0]
            tvShomTime.text = day.Maghrib.split(" ")[0]
            tvIshaTime.text = day.Isha.split(" ")[0]
        }
    }


    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            homeViewModel.prayerTimeState.collect { prayerTimeState ->
                when (prayerTimeState) {
                    is UiStateObject.SUCCESS -> {
                        // Update UI with data
                        val data = prayerTimeState.data // list of HijriCalendarResponse objects
                        setUpTimes(data)
                        homeViewModel.startCountdown(data)
                        Log.d("HOMESCREEN", "setUpObserversSuccess: ${data} ")

                    }
                    is UiStateObject.ERROR -> {
                        // Handle error
                        val errorMessage = prayerTimeState.message
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
            homeViewModel.currentTime.collect { pair ->
                val (def, text) = pair
                binding.tvDayLeft.text = def // update a TextView with the current time
                binding.tvDownCountTimer.text = text
            }
        }

    }
}
