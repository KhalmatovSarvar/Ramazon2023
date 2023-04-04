package com.shersar.ramazon2023.ui.tasbeh.viewmodel

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.repository.TasbehRepository
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import javax.inject.Inject

@HiltViewModel
class TasbehViewmodel @Inject constructor(
    private val tasbehRepository: TasbehRepository
): ViewModel()  {

    val _selectedZikr = MutableStateFlow(
        Zikr(
            1,
            "Субҳаналлоҳ",
            "سُبْحَانَ اللَّه",
            "Маьноси: Аллоҳни поклаб ёд этаман.",
            "0",
            "0"
        )
    )

    val selectedZikr: StateFlow<Zikr?> = _selectedZikr
//    private var drawerLayoutRef: WeakReference<DrawerLayout>? = null

    fun onZikrSelected(zikr: Zikr) {
        // Set the properties of the ViewModel for the object that you want to display the fields for
        _selectedZikr.value = zikr

    }


//    override fun onCleared() {
//        super.onCleared()
//        drawerLayoutRef = null
//    }


    private val _zikrState = MutableStateFlow<UiStateObject<Zikr>>(UiStateObject.EMPTY)
    val zikrState: StateFlow<UiStateObject<Zikr>> = _zikrState

    fun getZikrState() = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            _zikrState.value = UiStateObject.SUCCESS(
                Zikr(
                1,
                "Субҳаналлоҳ",
                "سُبْحَانَ اللَّه",
                "Маьноси: Аллоҳни поклаб ёд этаман.",
                "0",
                "0"
            )
            )
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun setZikrState(zikr: Zikr) = viewModelScope.launch {
        _zikrState.value = UiStateObject.LOADING
        try {
            _zikrState.value = UiStateObject.SUCCESS(zikr)
        } catch (e: Exception) {
            _zikrState.value = UiStateObject.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }

    fun incrementParams() {
        viewModelScope.launch {
            val currentZikrState = _zikrState.value
            Log.d("UpdatedZikr", "incrementTodayAndAllZikr: ${currentZikrState.toString()}")
            if (currentZikrState is UiStateObject.SUCCESS) {
                val currentZikr = currentZikrState.data
                val updatedZikr = currentZikr.copy(
                    today_zikr = (currentZikr.today_zikr.toInt() + 1).toString(),
                    all_zikr = (currentZikr.all_zikr.toInt() + 1).toString()
                )
                Log.d("UpdatedZikr", "incrementTodayAndAllZikr: ${updatedZikr.toString()}")
                tasbehRepository.updateCount(updatedZikr)
                _zikrState.value = UiStateObject.SUCCESS(updatedZikr)
            }
        }
    }


    private val _zikrListState = MutableStateFlow<UiStateList<Zikr>>(UiStateList.EMPTY)
    val zikrListState: StateFlow<UiStateList<Zikr>> = _zikrListState


    fun getAllZikr() = viewModelScope.launch {
        _zikrListState.value = UiStateList.LOADING

        try {
            val listZikr = tasbehRepository.getAllZikrFromDB()
            _zikrListState.value = UiStateList.SUCCESS(listZikr)
        }catch (e: Exception) {
            _zikrListState.value = UiStateList.ERROR(e.localizedMessage ?: "ERROR_MESSAGE")
        }
    }



}