package com.shersar.ramazon2023.repository.dateTimeRepo

import android.icu.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateTimeRepositoryImpl @Inject constructor() : DateTimeRepository {

    override fun getCurrentDateTime(): Pair<String, String> {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val date = dateFormat.format(calendar.time)
        val time = timeFormat.format(calendar.time)
        return Pair(date, time)
    }

    override fun getCurrentDate(): Long {
        return Calendar.getInstance().time.time
    }

}
