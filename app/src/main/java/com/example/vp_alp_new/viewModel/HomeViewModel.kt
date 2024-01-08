package com.example.vp_alp_new.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<near>?>(null)
    val uiState: StateFlow<List<near>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
            Log.d("Resto", "Tes")
            val restaurantList: List<near> =
                MyDBContainer().myDBRepositories.all_resto2(MyDBContainer.ACCESS_TOKEN)
           _uiState.value = restaurantList
        }
    }

//    fun getRestaurantsData() {
//        viewModelScope.launch {
////            Log.d("Resto Near: ", MyDBContainer().myDBRepositories.all_resto2(MyDBContainer.ACCESS_TOKEN).toString())
////            _uiState.value = MyDBContainer().myDBRepositories.all_resto2(MyDBContainer.ACCESS_TOKEN)
//
//        }
//    }
}