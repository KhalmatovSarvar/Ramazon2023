package com.shersar.ramazon2023.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.utils.activityNavController
import com.shersar.ramazon2023.utils.navigateSafely
import com.shersar.ramazon2023.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import viewBinding
import java.time.LocalTime
import java.util.*

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val homeViewModel: HomeViewModel by viewModels()
    private val binding by viewBinding { ScreenHomeBinding.bind(it) }
    private lateinit var location: String
    lateinit var time1: String
    lateinit var time2: String
    lateinit var time3: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getPrayerTimeByDay()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()
        setUpObservers()
        changeImagesByTime()
    }


    private fun changeImagesByTime() {
        /**
        // Split the time string into hours, minutes, and seconds
        val imageView = binding.ivIndiaMorning
        val parts = time1.split(":")
        val hours = parts[0].toInt()
        val minutes = parts[1].toInt()

        val parts1 = time1.split(":")
        val hours1= parts1[0].toInt()
        val minutes1 = parts1[1].toInt()

        val parts2 = time1.split(":")
        val hours2 = parts2[0].toInt()
        val minutes2 = parts2[1].toInt()


        // Create a LocalTime object with the hour, minute, and second values
        val localTime = LocalTime.of(hours, minutes)
        val localTime1 = LocalTime.of(hours1, minutes1)
        val localTime2 = LocalTime.of(hours2, minutes2)

        // Check if the time is in the morning, afternoon, or evening
        if (localTime.isBefore(LocalTime.of(hours1,minutes1))) {
        // Set the morning image in the ImageView
        imageView.setImageResource(R.drawable.im_india_day)
        } else if (localTime1.isBefore(LocalTime.of(hours2, minutes2))) {
        // Set the afternoon image in the ImageView
        imageView.setImageResource(R.drawable.im_india_sunset)
        } else {
        // Set the evening image in the ImageView
        imageView.setImageResource(R.drawable.im_india_night)
        }
         */
    }


    private fun initView() {
        location = requireActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            .getString("location", "Tashkent") ?: "Tashkent"
//        val imageView = binding.ivIndiaMorning
//        val calendar = Calendar.getInstance()
//        when (calendar.get(Calendar.HOUR_OF_DAY)) {
//            in 6..12 -> imageView.setImageResource(R.drawable.im_india_day)
//            in 13..19 -> imageView.setImageResource(R.drawable.im_india_sunset)
//            else -> imageView.setImageResource(R.drawable.im_india_night)
//        }
        binding.apply {
            tvLocation.text = location
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
    private fun setUpTimes(day: DailyPrayerTimesEntity) {
        binding.apply {
            tvDayHijriy.text = "${String.format("%02d", day.day.toInt())}.${
                String.format(
                    "%02d",
                    day.monthNumber
                )
            }.${day.year}"
            tvDayQamariy.text = "${day.dayHijri} ${day.monthNameEN} ${day.yearHijri}"

            tvSaharlik.text = day.fajr.split(" ")[0]
            time1 = day.fajr.split(" ")[0]//getting for image change

            tvQuyosh.text = day.Sunrise.split(" ")[0]
            tvIftorlik.text = day.Sunset.split(" ")[0]

            tvFajrTime.text = day.fajr.split(" ")[0]
            tvZuhrTime.text = day.Dhuhr.split(" ")[0]
            time2 = day.Dhuhr.split(" ")[0]//getting for image change
            tvAsrTime.text = day.Asr.split(" ")[0]
            tvShomTime.text = day.Maghrib.split(" ")[0]
            time3 = day.Maghrib.split(" ")[0]//getting for image change
            tvIshaTime.text = day.Isha.split(" ")[0]
            tvTahajjud.text = day.Lastthird.split(" ")[0]
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
                        homeViewModel.calcCurrentDefs()
                        Log.d("HOMESCREEN", "setUpObserversSuccess: ${data} ")

                    }
                    is UiStateObject.ERROR -> {
                        // Handle error
                        val errorMessage = prayerTimeState.message
                        Log.d("HOMESCREEN", "setUpObserversError: $errorMessage ")
//                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.LOADING -> {
                        // Show loading indicator
//                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.EMPTY -> {
                        // Handle empty state
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            homeViewModel.currentTime.collect { pair ->
                val (def, text, state) = pair
                binding.tvDayLeft.text = def // update a TextView with the current time
                binding.tvDownCountTimer.text = text

                binding.apply {
                    cvSaharlik.isActivated = state == "bomdod"
                    tvSaharlikTxt.isActivated = state == "bomdod"
                    tvSaharlik.isActivated = state == "bomdod"
                    ivSaharlik.isActivated = state == "bomdod"

                    cvIftorlik.isActivated = state == "shom"
                    tvIftorlikTxt.isActivated = state == "shom"
                    tvIftorlik.isActivated = state == "shom"
                    ivIftorlik.isActivated = state == "shom"

//                    ivIndiaMorning.setImageResource(R.drawable.im_india_sunset)
                }
            }


        }

    }
}
