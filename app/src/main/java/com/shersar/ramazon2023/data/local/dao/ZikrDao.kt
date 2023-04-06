package com.shersar.ramazon2023.data.local.dao

import androidx.room.*
import com.shersar.ramazon2023.data.local.entity.Zikr


@Dao
interface ZikrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZikr(zikr: Zikr)

    @Update(entity = Zikr::class)
    suspend fun updateCount(zikr: Zikr)

    @Query("SELECT * FROM zikr where id=:id")
    suspend fun getZikrByID(id: Int): Zikr

    @Query("SELECT * FROM zikr")
    suspend fun getAllZikr(): List<Zikr>

    @Query("UPDATE zikr SET today_zikr = '0'")
    suspend fun updateTodayZikrToZero()

    //This query will update the today_zikr field to 0 for
    // all records in the zikr table where the date field is not equal to the currentDate parameter.
    @Query("UPDATE zikr SET today_zikr = '0', date = :currentDate WHERE date != :currentDate")
    fun resetTodayZikr(currentDate: String)
}