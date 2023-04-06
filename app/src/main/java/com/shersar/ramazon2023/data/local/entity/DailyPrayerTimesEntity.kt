package com.shersar.ramazon2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Daily_prayer_times")
data class DailyPrayerTimesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val monthNumber: Int,
    val monthNumberHijri: Int,
    val monthNameEN: String,
    val monthNameArabic: String,
    val day: Int,
    val dayHijri: String,
    val year: String,
    val yearHijri: String,
    val weekday: String,

    val fajr: String,
    val Sunrise: String,
    val Dhuhr: String,
    val Asr: String,
    val Sunset: String,
    val Maghrib: String,
    val Isha: String,
    val Imsak: String,
    val Midnight: String,
    val Firstthird: String,
    val Lastthird: String,

    val date: String,
    val format: String
)


