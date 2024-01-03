package com.example.vp_alp_new.model

import java.sql.Time

data class Restaurant(
    val id: Int,
    val name: String,
    val rating: Double,
    val address: String,
    val phone: String,
    val open_time: Time,
    val close_time: Time,
    val image: String,
)