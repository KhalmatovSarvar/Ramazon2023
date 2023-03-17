package com.shersar.ramazon2023.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.HijriCalendarResponse
import com.shersar.ramazon2023.repository.HomeRepository
import com.shersar.ramazon2023.utils.UiStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiStateList<HijriCalendarResponse>>(UiStateList.EMPTY)

    val uiState: StateFlow<UiStateList<HijriCalendarResponse>>
        get() = _uiState

    fun getHijriCalendar(year: Int, month: Int, latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _uiState.value = UiStateList.LOADING
            val response = repository.getHijriCalendar(year, month, latitude, longitude)
            _uiState.value = response
        }
    }
}



