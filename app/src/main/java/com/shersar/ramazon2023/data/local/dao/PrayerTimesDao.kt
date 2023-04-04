package com.shersar.ramazon2023.data.local.dao

import androidx.room.*
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity

@Dao
interface PrayerTimesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prayerTime: DailyPrayerTimesEntity)

    @Query("SELECT * FROM Daily_prayer_times")
    suspend fun getAllPrayerTimes(): List<DailyPrayerTimesEntity>

    @Query("SELECT * FROM Daily_prayer_times where date=:date")
    suspend fun getPrayerTimesByDate(date: String): DailyPrayerTimesEntity

    @Query("SELECT * FROM Daily_prayer_times where id=:id")
    suspend fun getPrayerTimesById(id: Int): DailyPrayerTimesEntity

    @Query("DELETE FROM Daily_prayer_times")
    suspend fun clearTimes()

}