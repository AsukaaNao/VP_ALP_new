package com.example.vp_alp_new.repository

import android.util.Log
import com.example.vp_alp_new.model.APIResponse
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Food_review
import com.example.vp_alp_new.model.Food_reviewModel
import com.example.vp_alp_new.model.Liked_restaurant
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.Restaurant_review
import com.example.vp_alp_new.model.Restaurant_reviewModel
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer.Companion.user
import com.example.vp_alp_new.service.MyDBService
import com.example.vp_alp_new.ui.view.RestoReview
import com.google.gson.internal.LinkedTreeMap
import retrofit2.Response
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

    //    suspend fun logout(): String {
//        val result = myDBService.logout()
//        return result.message
//    }
//message
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

    suspend fun createRestoReviews(rating:Double, content: String, user_id: Int, restaurant_id:Int): String {
        // Create a User object with the provided parameters
        val restoreviews = Restaurant_reviewModel(
            rating = rating,
            content = content,
            user_id = user_id,
            restaurant_id = restaurant_id
        )

        val result = myDBService.createRestoReviews(restoreviews)

        return result.message
    }

    suspend fun createFoodReviews(rating:Double, content: String, user_id: Int, food_id:Int): String {
        // Create a User object with the provided parameters
        val foodreview = Food_reviewModel(
            rating = rating,
            content = content,
            user_id = user_id,
            food_id = food_id
        )

        val result = myDBService.createFoodReviews(foodreview)

        return result.message
    }

    suspend fun addFavResto(user_id: Int, restaurant_id: Int):String {
        val favResto = Liked_restaurant(
            user_id = user_id,
            restaurant_id = restaurant_id
        )

        val result = myDBService.addFavResto(favResto)

        return result.message
    }

    suspend fun deleteFavResto(user_id:Int, restaurant_id: Int) {
        Log.d("Step", "3")
        myDBService.deleteFavResto(MyDBContainer.ACCESS_TOKEN,user_id = user_id, restaurant_id = restaurant_id)
    }

    suspend fun isLikedResto(user_id: Int, restaurant_id: Int):Boolean {
        Log.d("STep", "3")
        return myDBService.isLikedResto(MyDBContainer.ACCESS_TOKEN,user_id = user_id, restaurant_id = restaurant_id)
    }


    suspend fun getUser(token: String): User {
        return myDBService.getUser("Bearer $token")
    }

    suspend fun getRestoReviews(token: String, id: Int): List<Restaurant_review> {
        val response: APIResponse = myDBService.getRestoReviews("Bearer $token", id)
            val data = response.data
            Log.d("data", data.toString())
            if (data is List<*>) {
                // Map each item in the list to a Restaurant_review object
                return data.mapNotNull { item ->
                    if (item is LinkedTreeMap<*, *>) {
                        val userMap = item["user"] as? Map<*, *>
                        Log.d("user", userMap.toString())
                        if (userMap != null) {
                            Restaurant_review(
                                id = (item["id"] as? Double)?.toInt() ?: 0,
                                user = parseUser(userMap),
                                content = item["content"] as? String ?: "",
                                rating = (item["rating"] as? Double ?: 0.0).toFloat()
                            )
                        } else {
                            Log.e("Error", "userMap")
                            null
                        }
                    } else {
                        Log.e("Error", "gakebaca as Linkedhashmap")
                        null
                    }
                }
        } else {
            Log.e("API Request Error: ", "API request failed with status ${response.status}")
        }

        return emptyList()
    }

    suspend fun getFoodReviews(token: String, id: Int): List<Food_review> {
        Log.d("sadasjk", "berhasil")
        val response: APIResponse = myDBService.getFoodReviews("Bearer $token", id)
        val data = response.data
        Log.d("data", data.toString())
        if (data is List<*>) {
            // Map each item in the list to a Restaurant_review object
            return data.mapNotNull { item ->
                if (item is LinkedTreeMap<*, *>) {
                    val userMap = item["user"] as? Map<*, *>
                    Log.d("user", userMap.toString())
                    if (userMap != null) {
                        Food_review(
                            id = (item["id"] as? Double)?.toInt() ?: 0,
                            user = parseUser(userMap),
                            content = item["content"] as? String ?: "",
                            rating = (item["rating"] as? Double ?: 0.0).toFloat()
                        )
                    } else {
                        Log.e("Error", "userMap")
                        null
                    }
                } else {
                    Log.e("Error", "gakebaca as Linkedhashmap")
                    null
                }
            }
        } else {
            Log.e("API Request Error: ", "API request failed with status ${response.status}")
        }

        return emptyList()
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

    private fun parseUser(userData: Map<*, *>): User {
        return User(
            id = (userData["id"] as? Int) ?: -1,
            name = userData["name"]?.toString() ?: "",
            phone = userData["phone"]?.toString() ?: "",
            email = userData["email"]?.toString() ?: "",
            password = userData["password"]?.toString() ?: ""
        )
    }

    private fun parseFood(item: Map<*, *>): Food {
        return Food(
            id = (item["id"] as? Double)?.toInt() ?: 0,
            name = item["name"]?.toString() ?: "",
            description = item["description"]?.toString() ?: "",
            price = (item["price"] as? Double) ?: 0.0,
//                    rating = (item["rating"] as? String)?.toDoubleOrNull() ?: 0.0,
            rating = (item["rating"] as? Double) ?: 0.0,
            image = item["image"]?.toString() ?: ""
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
    suspend fun getBestSeller(token: String): List<near> {
        val response: APIResponse = myDBService.bestSellers("Bearer $token")
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
    suspend fun getDibawah25k(token: String): List<near> {
        val response: APIResponse = myDBService.getDibawah25k("Bearer $token")
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

//    private fun parseFood(foodsData: List<*>): List<Food> {
//        return foodsData.mapNotNull { item ->
//            if (item is Map<*, *>) {
//                Food(
//                    id = (item["id"] as? Double)?.toInt() ?: 0,
//                    name = item["name"]?.toString() ?: "",
//                    description = item["description"]?.toString() ?: "",
//                    price = (item["price"] as? Double) ?: 0.0,
////                    rating = (item["rating"] as? String)?.toDoubleOrNull() ?: 0.0,
//                    rating = (item["rating"] as? Double) ?: 0.0,
//                    image = item["image"]?.toString() ?: ""
//                )
//            } else {
//                null
//            }
//        }
//    }

//    suspend fun updateUser(user: User): ApiResponse {
//        val updateUserRequest = UpdateUserRequest(
//            user.id,
//            user.name,
//            user.email,
//            user.password,
//            user.phone
//        )
//
//        return try {
//            userService.updateUser(updateUserRequest)
//        } catch (e: Exception) {
//            // Handle exceptions or errors during the API call
//            ApiResponse(-1, e.message ?: "Unknown error", Any())
//        }
//    }

}