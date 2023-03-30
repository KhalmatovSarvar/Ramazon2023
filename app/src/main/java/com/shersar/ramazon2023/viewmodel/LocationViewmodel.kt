package com.shersar.ramazon2023.viewmodel

import android.content.ContentValues
import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.model.MonthlyCalendar
import com.shersar.ramazon2023.repository.LocationRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val fusedLocationClient: FusedLocationProviderClient,
    private val dateTimeRepository: DateTimeRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {
    private val _locationFlow = MutableStateFlow<Location?>(null)
    val locationFlow: StateFlow<Location?> = _locationFlow

    init {
        viewModelScope.launch {
            try {
                val location = fusedLocationClient.lastLocation.await()
                _locationFlow.value = location
            } catch (e: SecurityException) {
                _locationFlow.value = null
            }
        }
    }

    private val _uiState = MutableStateFlow<UiStateObject<String>>(UiStateObject.EMPTY)

    val uiState: StateFlow<UiStateObject<String>>
        get() = _uiState

    fun getHijriCalendar(latitude: Double, longitude: Double) {
        val (date, time) = dateTimeRepository.getCurrentDateTime()
        val year = date.split("-")[0].toInt()
        val month = date.split("-")[1].toInt()
        viewModelScope.launch {
            _uiState.value = UiStateObject.LOADING
            try {
                val response = locationRepository.getMonthlyCalendarFromApi(year, month, latitude, longitude)
                _uiState.value = UiStateObject.SUCCESS("Success")

                Log.d(ContentValues.TAG, "getHijriCalendar: ${response.toString()}")
            } catch (e: Exception){
                _uiState.value = UiStateObject.ERROR(e.message ?: "Error occurred")
            }

        }
    }

    private val _prayerTimeInDB = MutableStateFlow<UiStateList<DailyPrayerTimesEntity>>(UiStateList.EMPTY)
    val prayerTimeInDB: StateFlow<UiStateList<DailyPrayerTimesEntity>>
        get() = _prayerTimeInDB

    fun getAllPrayerTimesFromDb() {
        viewModelScope.launch {
            _prayerTimeInDB.value = UiStateList.LOADING
            try {
                val response = locationRepository.getMonthlyCalendarFromDB()
                _prayerTimeInDB.value = UiStateList.SUCCESS(response)

            }catch (e: Exception){
                _prayerTimeInDB.value = UiStateList.ERROR(e.message ?: "Error occurred")
            }
            val times = locationRepository.getMonthlyCalendarFromDB()
        }
    }
}