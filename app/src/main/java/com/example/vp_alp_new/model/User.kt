package com.example.vp_alp_new.model

data class User(
    val id: Int = -1,
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = ""
) {
    constructor(email: String, password: String) : this(0, "", "", email, password)
}