package com.shersar.ramazon2023.ui.tasbeh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.Zikr
import com.shersar.ramazon2023.repository.TasbehRepository
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ZikrViewModel @Inject constructor(
    private val tasbehRepository: TasbehRepository
): ViewModel()  {

    val _homeState = MutableStateFlow(
        Zikr(
            1,
            "Субҳаналлоҳ",
            "سُبْحَانَ اللَّه",
            "Маьноси: Аллоҳни поклаб ёд этаман.",
            "0",
            "0"
        )
    )



    private val _zikrState = MutableStateFlow<UiStateObject<Zikr>>(UiStateObject.EMPTY)
    val zikrState: StateFlow<UiStateObject<Zikr>> = _zikrState

    fun getZikrState() = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            _zikrState.value = UiStateObject.SUCCESS(Zikr(
                1,
                "Субҳаналлоҳ",
                "سُبْحَانَ اللَّه",
                "Маьноси: Аллоҳни поклаб ёд этаман.",
                "0",
                "0"
            ))
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun setZikrState(zikr: Zikr) = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            tasbehRepository.updateCount(zikr)
            _zikrState.value = UiStateObject.SUCCESS(zikr)
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun incrementTodayAndAllZikr() = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            val currentZikrState = _zikrState.value
            if (currentZikrState is UiStateObject.SUCCESS) {
                val currentZikr = currentZikrState.data
                val updatedZikr = currentZikr.copy(
                    today_zikr = currentZikr.today_zikr + 1,
                    all_zikr = currentZikr.all_zikr + 1
                )
                tasbehRepository.updateCount(updatedZikr)
                _zikrState.value = UiStateObject.SUCCESS(updatedZikr)
            }
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

}


