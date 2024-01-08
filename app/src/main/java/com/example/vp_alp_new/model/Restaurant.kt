package com.example.vp_alp_new.model

import java.sql.Time
import java.time.LocalTime

data class Restaurant(
    val id: Any,
    val name: String,
    val rating: Double,
    val address: String,
    val phone: String,
    val open_time: LocalTime,
    val close_time: LocalTime,
    val image: String,
)