package com.shersar.ramazon2023.model

class Salovatlar(val name: String, vararg item: Item) {

    val listOfItems: List<Item> = item.toList()

}