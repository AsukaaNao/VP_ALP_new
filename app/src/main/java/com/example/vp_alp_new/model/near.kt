package com.example.vp_alp_new.model

import androidx.annotation.DrawableRes

data class near(
    var id: Int,
    var name: String,
    var rating: Float,
    var address: String,
    var phone:String,
//    @DrawableRes val image_path:Int,
    var image: String ? = ""

    )