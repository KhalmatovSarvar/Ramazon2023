package com.shersar.ramazon2023.ui.tasbeh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.Zikr
import com.shersar.ramazon2023.utils.UiStateObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalovatViewModel: ViewModel() {

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



    private val _salovatState = MutableStateFlow<UiStateObject<Zikr>>(UiStateObject.EMPTY)
    val zikrState: StateFlow<UiStateObject<Zikr>> = _salovatState

    fun getZikrState() = viewModelScope.launch {
        _salovatState.value = UiStateObject.LOADING
        try {
            _salovatState.value = UiStateObject.SUCCESS(Zikr(
                1,
                "Субҳаналлоҳ",
                "سُبْحَانَ اللَّه",
                "Маьноси: Аллоҳни поклаб ёд этаман.",
                "0",
                "0"
            ))
        } catch (e: Exception) {
            _salovatState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun setZikrState(zikr: Zikr) = viewModelScope.launch {
        _salovatState.value = UiStateObject.LOADING
        try {
            _salovatState.value = UiStateObject.SUCCESS(zikr)
        } catch (e: Exception) {
            _salovatState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }


}