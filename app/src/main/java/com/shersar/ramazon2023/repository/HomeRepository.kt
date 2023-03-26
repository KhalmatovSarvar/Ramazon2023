package com.shersar.ramazon2023.repository

import com.shersar.ramazon2023.data.remote.ApiService
import com.shersar.ramazon2023.model.MonthlyCalendar
import com.shersar.ramazon2023.utils.UiStateObject
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMonthlyCalendarFromApi(year: Int, month: Int, latitude: Double, longitude: Double): UiStateObject<MonthlyCalendar> {
        return try {
            val response = apiService.getMonthlyCalendar(year, month, latitude, longitude)
            if (response.isSuccessful) {
                val monthlyCalendar = response.body()
                if (monthlyCalendar != null) {
                    UiStateObject.SUCCESS(monthlyCalendar)
                } else {
                    UiStateObject.ERROR("Response body is null")
                }
            } else {
                UiStateObject.ERROR(response.message())
            }
        } catch (e: Exception) {
            UiStateObject.ERROR(e.message.toString())
        }
    }

}

