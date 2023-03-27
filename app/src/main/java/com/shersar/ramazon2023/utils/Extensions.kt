package com.shersar.ramazon2023.utils

import java.text.SimpleDateFormat
import java.util.*

fun toDateFromTimestamp(timestamp: Long, format: String): String{
    val mFormat = SimpleDateFormat(format, Locale.getDefault())
    return mFormat.format(Date(timestamp))
}

fun toTimestamp(dateString: String): Long{
    val dateFormat = SimpleDateFormat("dd-MM-yyyy, HH:mm", Locale.getDefault())
    val date = dateFormat.parse(dateString)
    return date?.time!!
}
