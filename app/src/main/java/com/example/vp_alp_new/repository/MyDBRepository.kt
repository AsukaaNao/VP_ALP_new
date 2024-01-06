package com.example.vp_alp_new.repository
import com.example.vp_alp_new.model.APIResponse
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.service.MyDBService
import okhttp3.Interceptor
import java.net.HttpURLConnection

class MyDBRepository(private val myDBService: MyDBService) {

    suspend fun login(email: String, password: String): String{
        val user = User(email = email, password = password)
        val result = myDBService.login(user)
        if(result.status.toInt() == HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }

    suspend fun logout(): String{
        val result = myDBService.logout()
        return result.message
    }

    suspend fun register(username: String, email: String, password: String, phone: String): String {
        // Create a User object with the provided parameters
        val user = User(
            name = username,
            phone = phone,
            email = email,
            password = password
        )

        // Make the network request to register the user
        val result = myDBService.register(user)

        // Check the status in the response
//        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
//            return result.data as String
//        }

        // Return the error message if the registration was not successful
        return result.message
    }


    suspend fun getUser(token: String): User {
        return myDBService.getUser("Bearer $token")
    }

}