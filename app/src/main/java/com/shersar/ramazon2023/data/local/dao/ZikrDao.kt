package com.shersar.ramazon2023.data.local.dao

import androidx.room.*
import com.shersar.ramazon2023.data.local.entity.ZikrEntity
import com.shersar.ramazon2023.model.Zikr


@Dao
interface ZikrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertZikr(zikr:ZikrEntity)

    @Update
    suspend fun updateCount(zikr:ZikrEntity)

    @Query("SELECT * FROM zikr where id=:id")
    suspend fun getZikrByID(id:Int):Zikr

    @Query("SELECT * FROM zikr")
    suspend fun getAllZikr():List<Zikr>

}