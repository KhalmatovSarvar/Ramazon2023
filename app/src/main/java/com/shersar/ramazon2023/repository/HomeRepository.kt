package com.shersar.ramazon2023.repository

import com.shersar.ramazon2023.data.remote.ApiService
import com.shersar.ramazon2023.model.HijriCalendarResponse
import com.shersar.ramazon2023.utils.UiStateList
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getHijriCalendar(year: Int, month: Int, latitude: Double, longitude: Double): UiStateList<HijriCalendarResponse> {
        return try {
            val response = apiService.getHijriCalendar(year, month, latitude, longitude)
            if (response.isSuccessful) {
                val hijriCalendarResponse = response.body()
                if (hijriCalendarResponse != null) {
                    val data = listOf(hijriCalendarResponse)
                    UiStateList.SUCCESS(data)
                } else {
                    UiStateList.ERROR("Response body is null")
                }
            } else {
                UiStateList.ERROR(response.message(), true)
            }
        } catch (e: Exception) {
            UiStateList.ERROR(e.message.toString())
        }
    }

}

