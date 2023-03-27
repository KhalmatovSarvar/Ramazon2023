package com.shersar.ramazon2023.repository.dateTimeRepo

interface DateTimeRepository {
    fun getCurrentDateTime(): Pair<String, String>
    fun getCurrentDate(): Long
}
