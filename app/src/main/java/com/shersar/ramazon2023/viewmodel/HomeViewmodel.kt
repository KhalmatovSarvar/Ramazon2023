package com.shersar.ramazon2023.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.repository.LocationRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.utils.toTimestamp
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

    private val _prayerTimeByDayState = MutableStateFlow<UiStateObject<DailyPrayerTimesEntity>>(UiStateObject.EMPTY)
    val prayerTimeState: StateFlow<UiStateObject<DailyPrayerTimesEntity>>
        get() = _prayerTimeByDayState

    fun getPrayerTimeByDay() {
        val (date, time) = dateTimeRepository.getCurrentDateTime()
        viewModelScope.launch {
            _prayerTimeByDayState.value = UiStateObject.LOADING
            try {
                val response = locationRepository.getPrayerTimesByDay(date.split("-")[2])
                _prayerTimeByDayState.value = UiStateObject.SUCCESS(response)

            }catch (e: Exception){
                _prayerTimeByDayState.value = UiStateObject.ERROR(e.message ?: "Error occurred")
            }
        }
    }

    private val _currentTime = MutableStateFlow<Pair<String, String>>(Pair("00:00:00", "Saharlikka qoldi"))
    val currentTime: StateFlow<Pair<String, String>>
        get() = _currentTime

    private fun startCountdown(day: DailyPrayerTimesEntity, tomorrow: DailyPrayerTimesEntity) {
        val (date, time) = dateTimeRepository.getCurrentDateTime()
        val (endTimeMillis, text) = calculateMillsDef(day, tomorrow)
        val countDownTimer = object : CountDownTimer(endTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Calculate hours, minutes, and seconds from milliseconds
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val minutes = (millisUntilFinished / (1000 * 60)) % 60
                val seconds = (millisUntilFinished / 1000) % 60

                // Update the current time with the remaining time
                val formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                _currentTime.value = Pair(formattedTime, text)
            }

            override fun onFinish() {
                // Do something when the countdown finishes
                startCountdown(day, tomorrow)
            }
        }
        countDownTimer.start()
    }

    private fun calculateMillsDef(day: DailyPrayerTimesEntity, tomorrow: DailyPrayerTimesEntity): Pair<Long, String>{
        val currentDate = dateTimeRepository.getCurrentDate()

        val comingSunset = toTimestamp("${day.date}, ${day.Maghrib.split(" ")[0]}")

        val comingFajr = toTimestamp("${day.date}, ${day.fajr.split(" ")[0]}")
        val comingFajrTomorrow = toTimestamp("${tomorrow.date}, ${tomorrow.fajr.split(" ")[0]}")

        Log.d("HomeViewModel Times: ", " Cur: $currentDate, <  $comingFajr < $comingSunset")

        return if (currentDate < comingFajr){
            Pair(comingFajr - currentDate, "Saharlikka qoldi")
        } else if (currentDate < comingSunset){
            Pair(comingSunset - currentDate, "Iftorlikka qoldi")
        } else {
            Pair(comingFajrTomorrow - currentDate, "Saharlikka qoldi")
        }
    }

    fun calcCurrentDefs(){
        viewModelScope.launch {
            try {
                val (today, tomorrow) = locationRepository.getPrayerTimeWithNextDay()
                startCountdown(today, tomorrow)

            }catch (e:Exception){
                _currentTime.value = Pair("00:00:00", "Saharlikka qoldi")
            }
        }
    }

    fun timeToMillis(timeString: String): Long {
        val timeParts = timeString.split(":")
        val hours = timeParts[0].toLong()
        val minutes = timeParts[1].toLong()
        val seconds = timeParts[2].toLong()
        return ((hours * 3600) + (minutes * 60) + seconds) * 1000
    }

}



