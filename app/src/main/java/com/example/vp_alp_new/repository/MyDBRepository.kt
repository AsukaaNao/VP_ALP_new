package com.example.vp_alp_new.repository

import android.util.Log
import com.example.vp_alp_new.model.APIResponse
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.service.MyDBService
import com.google.gson.internal.LinkedTreeMap
import java.math.BigDecimal
import java.net.HttpURLConnection
import java.time.LocalTime

class MyDBRepository(private val myDBService: MyDBService) {

    suspend fun login(email: String, password: String): String {
        val user = User(email = email, password = password)
        val result = myDBService.login(user)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result.data as String
        }
        return result.message
    }

    suspend fun logout(): String {
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

    suspend fun all_resto2(token: String): List<near> {
        val response: APIResponse = myDBService.all_resto2("Bearer $token")
        if (response.status == "200") {
            val data = response.data
            if (data is List<*>) {
                // Map each item in the list to a Restaurant object
                return data.mapNotNull { item ->
                    if (item is LinkedTreeMap<*, *>) {
                        near(
                            id = (item["id"] as? Double)?.toInt() ?: 0,
                            name = item["name"]?.toString() ?: "",
                            address = item["address"]?.toString() ?: "",
                            phone = item["phone"]?.toString() ?: "",
                            rating = (item["rating"] as Double).toFloat(),
                            image = item["image"]?.toString()
                        )
                    } else {
                        null
                    }
                }
            } else {
                Log.e("API Request Error: ", "API request failed with status ${response.status}")
                return emptyList() // or handle the error accordingly
            }
        }
        return emptyList()
    }

    suspend fun getAllFoodByResto(token: String, id: Int): Pair<Restaurant?, List<Food>> {
        val response = myDBService.allFoodByResto("Bearer $token", id)

        if (response.status == "200") {
            val data = response.data
            if (data is Map<*, *>) {
                val restaurant = parseRestaurant(data["restaurant"] as Map<*, *>)
                val foods = parseFoods(data["foods"] as List<*>)

                return Pair(restaurant, foods)
            } else {
                Log.e("API Request Error: ", "API request failed with status ${response.status}")
            }
        }

        return Pair(null, emptyList())
    }

    private fun parseRestaurant(restaurantData: Map<*, *>): Restaurant {
        return Restaurant(
            id = (restaurantData["id"] as? Double)?.toInt() ?: 0,
            name = restaurantData["name"]?.toString() ?: "",
            rating = (restaurantData["rating"] as? Double) ?: 0.0,
            address = restaurantData["address"].toString(),
            phone = restaurantData["phone"].toString(),
            open_time = LocalTime.parse(restaurantData["open_time"]?.toString() ?: "00:00:00"),
            close_time = LocalTime.parse(restaurantData["close_time"]?.toString() ?: "00:00:00"),
            image = restaurantData["image"]?.toString() ?: ""
        )
    }

    private fun parseFoods(foodsData: List<*>): List<Food> {
        return foodsData.mapNotNull { item ->
            if (item is Map<*, *>) {
                Food(
                    id = (item["id"] as? Double)?.toInt() ?: 0,
                    name = item["name"]?.toString() ?: "",
                    description = item["description"]?.toString() ?: "",
                    price = (item["price"] as? Double) ?: 0.0,
//                    rating = (item["rating"] as? String)?.toDoubleOrNull() ?: 0.0,
                    rating = (item["rating"] as? Double) ?: 0.0,
                    image = item["image"]?.toString() ?: ""
                )
            } else {
                null
            }
        }
    }
}
