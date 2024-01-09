package com.example.vp_alp_new.repository


import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.service.MyDBService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AuthInterceptor(private val bearerToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $bearerToken")
            .build()
        return chain.proceed(request)
    }
}
class MyDBContainer() {

    companion object{
        var ACCESS_TOKEN = ""
        lateinit var user: User
    }

    private val BASE_URL = "http://192.168.1.10/Api_alp/public/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: MyDBService by lazy{
        retrofit.create(MyDBService::class.java)
    }
    val myDBRepositories: MyDBRepository by lazy{
        MyDBRepository(retrofitService)
    }
}