package com.example.vp_alp_new.model

data class Food(
    val id:Int,
//    val restaurant: Restaurant,
//    val category: Category,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val image: String
)