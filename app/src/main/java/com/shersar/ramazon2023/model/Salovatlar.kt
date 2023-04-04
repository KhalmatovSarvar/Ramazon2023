package com.shersar.ramazon2023.model

import com.shersar.ramazon2023.data.local.entity.Zikr

class Salovatlar(val name: String, vararg zikr: Zikr) {

    val listOfZikrs: List<Zikr> = zikr.toList()

}