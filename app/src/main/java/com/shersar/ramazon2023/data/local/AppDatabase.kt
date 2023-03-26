package com.shersar.ramazon2023.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shersar.ramazon2023.data.local.dao.PrayerTimesDao
import com.shersar.ramazon2023.data.local.entity.DailyPrayerTimesEntity
import com.shersar.ramazon2023.utils.Constants

@Database(entities = [DailyPrayerTimesEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun prayerDao(): PrayerTimesDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {

            if (instance == null)
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    Constants.WORD_DATABASE
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

            return instance!!
        }
    }
}
