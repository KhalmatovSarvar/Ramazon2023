package com.shersar.ramazon2023.repository

import com.shersar.ramazon2023.data.local.dao.ZikrDao
import com.shersar.ramazon2023.data.local.entity.Zikr
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TasbehRepository @Inject constructor(
    private val zikrDao: ZikrDao,
) {

   suspend fun getAllZikrFromDB():List<Zikr>{
       val zikrList = zikrDao.getAllZikr()
       return zikrList
   }

    suspend fun getZikr(id:Int):Zikr{
        val zikr = zikrDao.getZikrByID(id)
        return zikr
    }

    suspend fun updateCount(zikr:Zikr){
        zikrDao.updateCount(zikr)
    }

    suspend fun addZikr(zikr:Zikr){
        zikrDao.insertZikr(zikr)
    }

    suspend fun resetTodayZikr(currentDate: String) {
        withContext(Dispatchers.IO) {
            zikrDao.resetTodayZikr(currentDate)
        }
    }

    suspend fun resetAllCurrentZikrs() {
        val allZikrs = zikrDao.getAllZikr()
        allZikrs.forEach { zikr ->
            zikr.current_zikr = "0"
            zikrDao.updateCount(zikr)
        }
    }




}