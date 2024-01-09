package com.example.vp_alp_new.model

data class Food_reviewModel(
    val content: String,
    val rating: Double,
    val user_id: Int,
    val food_id: Int
)
