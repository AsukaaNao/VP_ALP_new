package com.example.vp_alp_new.model

data class Food_review(
    val id:Int,
    val user: User,
    val content:String,
    val rating:Float
)