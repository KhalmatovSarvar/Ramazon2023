package com.shersar.ramazon2023.model

class Bottomsheet(
    var city_name: Location,
    var isSelected: Boolean

) {

    override fun toString(): String {
        return "Bottomsheet(city_name='$city_name', isSelected=$isSelected)"
    }
}