package com.shersar.ramazon2023.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity

@Dao
interface PrayerTimesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prayerTime: DailyPrayerTimesEntity)

    @Query("SELECT * FROM Daily_prayer_times")
    suspend fun getAllPrayerTimes(): List<DailyPrayerTimesEntity>

    @Query("SELECT * FROM Daily_prayer_times where day=:day")
    suspend fun getPrayerTimesByDay(day: String): DailyPrayerTimesEntity

}