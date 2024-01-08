package com.example.vp_alp_new.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.Category
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.RestoDetailUIState
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.LocalTime

class RestoDetailViewModel : ViewModel() {

    private val _restaurant = MutableStateFlow<Restaurant?>(null)
    private val _foods = MutableStateFlow<List<Food>>(emptyList())

    val restaurant: StateFlow<Restaurant?> = _restaurant
    val foods: StateFlow<List<Food>> = _foods

    fun fetchData(id: Int) {
        viewModelScope.launch {
            val (restaurantData, foodsData) = MyDBContainer().myDBRepositories.getAllFoodByResto(MyDBContainer.ACCESS_TOKEN, id)

            _restaurant.value = restaurantData
            Log.d("Resto", restaurantData.toString())
            _foods.value = foodsData
            Log.d("Food", foodsData.toString())
        }
    }
}