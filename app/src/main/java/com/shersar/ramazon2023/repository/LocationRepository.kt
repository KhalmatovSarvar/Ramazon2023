package com.shersar.ramazon2023.repository

import android.util.Log
import com.shersar.ramazon2023.data.local.dao.PrayerTimesDao
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.data.remote.ApiService
import com.shersar.ramazon2023.model.DailyPrayerTime
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepositoryImpl
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val apiService: ApiService,
    private val prayerTimesDao: PrayerTimesDao,
    private val dateTimeRepository: DateTimeRepository
) {
    suspend fun getMonthlyCalendarFromApi(
        year: Int,
        month: Int,
        latitude: Double,
        longitude: Double
    ) {
        try {
            val response = apiService.getMonthlyCalendar(year, month, latitude, longitude)
            Log.d("LocationRepository", "getMonthlyCalendarFromApi: I am in locationRepo")

            if (response.isSuccessful) { // Check if the response is successful
                val items = response.body() // Extract the list of items from the response body
                if (items != null && items.data!!.isNotEmpty()) {
                    // Save the list of items to the Room database
                    Log.d("LocationRepository", "getMonthlyCalendarFromApi: I am in locationRepo and saving")

                    for (i in 0 until items.data.size) {

                        Log.d("OBJECTPRAYERTIME", "getMonthlyCalendarFromApi: ${items.data[i]?.date?.gregorian.toString()}")


                        val prayerTime = DailyPrayerTime(
                            monthNumber = items.data[i]?.date?.gregorian?.month?.number!!.toInt(),
                            monthNumberHijri = items.data[i]?.date?.hijri?.month?.number!!.toInt(),
                            monthNameEN = items.data[i]?.date?.hijri?.month?.en.toString(),
                            monthNameArabic = items.data[i]?.date?.hijri?.month?.ar.toString(),
                            day = items.data[i]?.date?.gregorian?.day.toString(),
                            dayHijri = items.data[i]?.date?.hijri?.day.toString(),
                            year = items.data[i]?.date?.gregorian?.year.toString(),
                            yearHijri = items.data[i]?.date?.hijri?.year.toString(),
                            weekday = items.data[i]?.date?.gregorian?.weekday?.en.toString(),
                            fajr = items.data[i]?.timings?.Fajr.toString(),
                            sunrise = items.data[i]?.timings?.Sunrise.toString(),
                            dhuhr = items.data[i]?.timings?.Dhuhr.toString(),
                            asr = items.data[i]?.timings?.Asr.toString(),
                            sunset = items.data[i]?.timings?.Sunset.toString(),
                            maghrib = items.data[i]?.timings?.Maghrib.toString(),
                            isha = items.data[i]?.timings?.Isha.toString(),
                            imsak = items.data[i]?.timings?.Imsak.toString(),
                            midnight = items.data[i]?.timings?.Midnight.toString(),
                            firstthird = items.data[i]?.timings?.Firstthird.toString(),
                            lastthird = items.data[i]?.timings?.Lastthird.toString(),
                            date = items.data[i]?.date?.gregorian?.date.toString(),
                            format = items.data[i]?.date?.gregorian?.format.toString()
                        )

                        val prayerTimesToEntity = DailyPrayerTimesEntity(
                            0,
                            prayerTime.monthNumber,
                            prayerTime.monthNumberHijri,
                            prayerTime.monthNameEN,
                            prayerTime.monthNameArabic,
                            prayerTime.day,
                            prayerTime.dayHijri,
                            prayerTime.year,
                            prayerTime.yearHijri,
                            prayerTime.weekday,
                            prayerTime.fajr,
                            prayerTime.sunrise,
                            prayerTime.dhuhr,
                            prayerTime.asr,
                            prayerTime.sunset,
                            prayerTime.maghrib,
                            prayerTime.isha,
                            prayerTime.imsak,
                            prayerTime.midnight,
                            prayerTime.firstthird,
                            prayerTime.lastthird,
                            prayerTime.date,
                            prayerTime.format
                        )

                        Log.d("DB SAVED OBJECT ", "getMonthlyCalendarFromApi: ${prayerTimesToEntity.toString()}")

                        prayerTimesDao.insert(prayerTimesToEntity)


                    }
                }
            } else {
                // Handle the API call failure case
                val errorBody = response.errorBody()?.string()
                // ...
            }
        } catch (e: Exception) {
            Log.d("LocationRepository", "getMonthlyCalendarFromApi: ${e.message.toString()}")
        }
    }

    suspend fun getMonthlyCalendarFromDB() = prayerTimesDao.getAllPrayerTimes()

    suspend fun getPrayerTimesByDate(date: String) = prayerTimesDao.getPrayerTimesByDate(date)

    suspend fun getPrayerTimeWithNextDay(): Pair<DailyPrayerTimesEntity, DailyPrayerTimesEntity>{
        val (date, time) = dateTimeRepository.getCurrentDateTime()
        val today = date
        val tomorrowId = prayerTimesDao.getPrayerTimesByDate(date).id+1
        return Pair(prayerTimesDao.getPrayerTimesByDate(today), prayerTimesDao.getPrayerTimesById(tomorrowId))
    }
}