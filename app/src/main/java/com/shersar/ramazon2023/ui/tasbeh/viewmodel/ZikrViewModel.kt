package com.shersar.ramazon2023.ui.tasbeh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ZikrViewModel: ViewModel() {

    val _homeState = MutableStateFlow(Item(
        1,
        "Subhanalloh",
        " سُبْحَانَ اللهِ",
        "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
        "10",
        "255"
    ))



    private val _zikrState = MutableStateFlow<UiStateObject<Item>>(UiStateObject.EMPTY)
    val zikrState: StateFlow<UiStateObject<Item>> = _zikrState

    fun getZikrState() = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            _zikrState.value = UiStateObject.SUCCESS(Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            ))
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun setZikrState(item: Item) = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            _zikrState.value = UiStateObject.SUCCESS(item)
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }


}