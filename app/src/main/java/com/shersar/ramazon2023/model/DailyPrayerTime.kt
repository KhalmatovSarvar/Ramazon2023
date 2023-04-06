package com.shersar.ramazon2023.model

data class DailyPrayerTime(
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
    val sunrise: String,
    val dhuhr: String,
    val asr: String,
    val sunset: String,
    val maghrib: String,
    val isha: String,
    val imsak: String,
    val midnight: String,
    val firstthird: String,
    val lastthird: String,

    val date: String,
    val format: String
)