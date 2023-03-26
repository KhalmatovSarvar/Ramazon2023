package com.shersar.ramazon2023.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.MonthlyCalendar
import com.shersar.ramazon2023.repository.HomeRepository
import com.shersar.ramazon2023.repository.LocationRepository
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

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


}



