package com.shersar.ramazon2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zikr")
data class ZikrEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val uzb_zikr: String,
    val arab_zikr: String,
    val tarjima: String,
    val today_zikr: String,
    val all_zikr: String
)
