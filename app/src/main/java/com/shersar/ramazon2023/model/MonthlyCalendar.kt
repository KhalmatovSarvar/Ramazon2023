package com.shersar.ramazon2023.model

import androidx.room.Entity

data class MonthlyCalendar(
	val code: Int? = null,
	val data: List<DataItem?>? = null,
	val status: String? = null
)

data class Gregorian(
	val date: String? = null,
	val month: Month? = null,
	val year: String? = null,
	val format: String? = null,
	val weekday: Weekday? = null,
	val designation: Designation? = null,
	val day: String? = null
)

data class Offset(
	val sunset: String? = null,
	val asr: Int? = null,
	val isha: Int? = null,
	val fajr: Int? = null,
	val dhuhr: String? = null,
	val maghrib: String? = null,
	val sunrise: Int? = null,
	val midnight: Int? = null,
	val imsak: Int? = null
)

data class Hijri(
	val date: String? = null,
	val month: Month? = null,
	val holidays: List<Any?>? = null,
	val year: String? = null,
	val format: String? = null,
	val weekday: Weekday? = null,
	val designation: Designation? = null,
	val day: String? = null
)

data class Method(
	val name: String? = null,
	val params: Params? = null
)

data class DataItem(
	val date: Date? = null,
	val meta: Meta? = null,
	val timings: Timings? = null
)

data class Month(
	val number: Int? = null,
	val en: String? = null,
	val ar: String? = null
)

data class Designation(
	val expanded: String? = null,
	val abbreviated: String? = null
)

data class Meta(
	val method: Method? = null,
	val offset: Offset? = null,
	val school: String? = null,
	val timezone: String? = null,
	val midnightMode: String? = null,
	val latitude: Any? = null,
	val longitude: Any? = null,
	val latitudeAdjustmentMethod: String? = null
)

data class Weekday(
	val en: String? = null,
	val ar: String? = null
)

data class Params(
	val isha: String? = null,
	val fajr: String? = null,
	val maghrib: String? = null
)

data class Timings(
	val Sunset: String? = null,
	val Asr: String? = null,
	val Isha: String? = null,
	val Fajr: String? = null,
	val Dhuhr: String? = null,
	val Maghrib: String? = null,
	val Lastthird: String? = null,
	val Firstthird: String? = null,
	val Sunrise: String? = null,
	val Midnight: String? = null,
	val Imsak: String? = null
)

data class Date(
	val readable: String? = null,
	val hijri: Hijri? = null,
	val gregorian: Gregorian? = null,
	val timestamp: String? = null
)

