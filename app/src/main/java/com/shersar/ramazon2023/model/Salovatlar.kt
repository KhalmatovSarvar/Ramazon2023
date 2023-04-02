package com.shersar.ramazon2023.model

class Salovatlar(val name: String, vararg zikr: Zikr) {

    val listOfZikrs: List<Zikr> = zikr.toList()

}