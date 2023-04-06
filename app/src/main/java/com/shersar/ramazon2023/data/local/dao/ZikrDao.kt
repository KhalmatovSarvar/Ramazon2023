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

}