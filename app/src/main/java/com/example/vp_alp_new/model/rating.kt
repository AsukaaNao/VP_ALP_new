package com.example.vp_alp_new.model

import androidx.annotation.DrawableRes

data class rating(
    var contex: String,
    var rating: Int,
    var username: String,
    @DrawableRes val image_path:Int,
)