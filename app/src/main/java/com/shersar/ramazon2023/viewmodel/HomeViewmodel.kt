package com.shersar.ramazon2023.viewmodel

import android.content.ContentValues.TAG
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.MonthlyCalendar
import com.shersar.ramazon2023.repository.LocationRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dateTimeRepository: DateTimeRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    //opened dev
    private val _uiState = MutableStateFlow<UiStateObject<MonthlyCalendar>>(UiStateObject.EMPTY)

    val uiState: StateFlow<UiStateObject<MonthlyCalendar>>
        get() = _uiState

    fun getHijriCalendar(year: Int, month: Int, latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _uiState.value = UiStateObject.LOADING
            val response = locationRepository.getMonthlyCalendarFromApi(year, month, latitude, longitude)
            Log.d(TAG, "getHijriCalendar: ${response.toString()}")
//            _uiState.value = response
        }
    }

    fun getAllPrayerTimesFromDb(){
        viewModelScope.launch {
            val times = locationRepository.getMonthlyCalendarFromDB()
        }
    }

    private val _currentTime = MutableStateFlow("00:00:00")
    val currentTime: StateFlow<String>
        get() = _currentTime





    fun startCountdown() {
        val (date, time) = dateTimeRepository.getCurrentDateTime()
        val endTimeMillis = timeToMillis(time)
        val countDownTimer = object : CountDownTimer(endTimeMillis , 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Calculate hours, minutes, and seconds from milliseconds
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val minutes = (millisUntilFinished / (1000 * 60)) % 60
                val seconds = (millisUntilFinished / 1000) % 60

                // Update the current time with the remaining time
                val formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                _currentTime.value = formattedTime
            }

            override fun onFinish() {
                // Do something when the countdown finishes
                _currentTime.value = "00:00:00"
            }
        }
        countDownTimer.start()
    }

    fun timeToMillis(timeString: String): Long {
        val timeParts = timeString.split(":")
        val hours = timeParts[0].toLong()
        val minutes = timeParts[1].toLong()
        val seconds = timeParts[2].toLong()
        return ((hours * 3600) + (minutes * 60) + seconds) * 1000
    }





}



