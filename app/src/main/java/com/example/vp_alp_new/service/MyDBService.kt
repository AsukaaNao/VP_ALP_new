package com.example.vp_alp_new.service

import com.example.vp_alp_new.model.APIResponse
import com.example.vp_alp_new.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface MyDBService {
    @POST("login")
    suspend fun login(@Body user: User): APIResponse

    @DELETE("logout")
    suspend fun logout(): APIResponse

    @POST("create_user")
    suspend fun register(@Body user: User): APIResponse
}