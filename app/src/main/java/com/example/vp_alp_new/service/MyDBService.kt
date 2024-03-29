package com.example.vp_alp_new.service

import com.example.vp_alp_new.model.APIResponse
import com.example.vp_alp_new.model.Food_reviewModel
import com.example.vp_alp_new.model.Liked_restaurant
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.Restaurant_review
import com.example.vp_alp_new.model.Restaurant_reviewModel
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.model.near
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface MyDBService {
    @POST("login")
    suspend fun login(@Body user: User): APIResponse

    @DELETE("logout")
    suspend fun logout(): APIResponse
    @POST("register")
    suspend fun register(@Body user: User): APIResponse

    @GET("all_resto")
    suspend fun all_resto2(@Header("Authorization") token: String): APIResponse

    // Food Endpoints
    @GET("all_foodbyresto")
    suspend fun allFoodByResto(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse

    @GET("resto_reviews")
    suspend fun getRestoReviews(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse

    @POST("make_restoreviews")
    suspend fun createRestoReviews(@Body restoreview: Restaurant_reviewModel): APIResponse

    @POST("make_foodreviews")
    suspend fun createFoodReviews(@Body foodreview: Food_reviewModel): APIResponse

    @GET("food_reviews")
    suspend fun getFoodReviews(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse

//    @GET("food_reviews")
//    suspend fun getFoodReviews(@Header("Authorization") token: String, @Query("user_id") user_id: Int, @Query("restaurant_id") restaurant_id: Int): Boolean

    @POST("add_favresto")
    suspend fun addFavResto(@Body likedRestaurant: Liked_restaurant): APIResponse

    @DELETE("delete_favresto")
    suspend fun deleteFavResto(@Header("Authorization") token: String, @Query("user_id") user_id: Int, @Query("restaurant_id") restaurant_id: Int): APIResponse

    @GET("isliked_resto")
    suspend fun isLikedResto(@Header("Authorization") token: String, @Query("user_id") user_id: Int, @Query("restaurant_id") restaurant_id: Int): Boolean

//    @PATCH("update_user")
//    suspend fun updateUser(@Body request: UpdateUserRequest): APIResponse

    @DELETE("delete_user")
    suspend fun deleteUser(): APIResponse
    @GET("user")
    suspend fun getUser(@Header("Authorization") token: String): User


    @GET("user_favresto")
    suspend fun likedlist(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse


    @GET("user_wishlist")
    suspend fun wishlistResto(): APIResponse

    @GET("user_restoreview")
    suspend fun userRestoReview(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse

    @GET("user_foodreview")
    suspend fun userFoodReview(@Header("Authorization") token: String, @Query("id") id: Int): APIResponse

    // Restaurant Endpoints
    @GET("best_sellers")
    suspend fun bestSellers(@Header("Authorization") token: String): APIResponse

    @GET("hemat")
    suspend fun getDibawah25k(@Header("Authorization") token: String): APIResponse

    @GET("resto_food")
    suspend fun restoFood(): APIResponse

    @GET("resto_beverage")
    suspend fun restoBeverage(): APIResponse

    @GET("resto_snack")
    suspend fun restoSnack(): APIResponse

    @GET("search_resto")
    suspend fun searchResto(): APIResponse


//
//    @PATCH("edit_restoreviews")
//    suspend fun updateRestoReviews(@Body request: UpdateRestoReviewRequest): APIResponse



    @GET("resto_details")
    suspend fun restoDetailsWithFood(): APIResponse

//
//    @PATCH("edit_foodreviews")
//    suspend fun updateFoodReviews(@Body request: UpdateFoodReviewRequest): APIResponse



}