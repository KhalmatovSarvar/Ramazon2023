package com.shersar.ramazon2023.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.repository.LocationRepository
import com.shersar.ramazon2023.repository.TasbehRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.utils.UiStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dateTimeRepository: DateTimeRepository,
    private val locationRepository: LocationRepository,
    private val tasbehRepository: TasbehRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiStateList<DailyPrayerTimesEntity>>(UiStateList.EMPTY)
    val uiState: StateFlow<UiStateList<DailyPrayerTimesEntity>>
        get() = _uiState

    fun getAllPrayerTimesFromDb() {
        viewModelScope.launch {
            _uiState.value = UiStateList.LOADING
            try {
                val response = locationRepository.getMonthlyCalendarFromDB()
                _uiState.value = UiStateList.SUCCESS(response)

            }catch (e: Exception){
                _uiState.value = UiStateList.ERROR(e.message ?: "Error occurred")
            }
            val times = locationRepository.getMonthlyCalendarFromDB()
        }
    }

}



