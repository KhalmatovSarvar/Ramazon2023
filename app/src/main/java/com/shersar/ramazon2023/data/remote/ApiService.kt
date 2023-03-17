package com.shersar.ramazon2023.data.remote

import com.shersar.ramazon2023.model.HijriCalendarResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v1/hijriCalendar/{year}/{month}")
      suspend  fun getHijriCalendar(
        @Path("year") year: Int = 1444,
        @Path("month") month: Int = 9,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Int = 99,
        @Query("school") school: Int = 1,
        @Query("methodSettings") methodSettings: String? = "15.5,null,15.5",
        @Query("tune") tune: String? = "0,0,0,5,0,2,2,0"
        ): Response<HijriCalendarResponse>
    }

