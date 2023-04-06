package com.shersar.ramazon2023.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zikr")
data class Zikr(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val uzb_zikr: String,
    val arab_zikr: String,
    val tarjima: String,
    val today_zikr: String,
    val all_zikr: String
)
