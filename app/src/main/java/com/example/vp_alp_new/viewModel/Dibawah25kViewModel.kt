package com.example.vp_alp_new.viewModel
import androidx.lifecycle.viewModelScope
import android.util.Log
import androidx.lifecycle.ViewModel

import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Dibawah25kViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<List<near>?>(null)
    val uiState: StateFlow<List<near>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
            val restaurantList: List<near> =
                MyDBContainer().myDBRepositories.getDibawah25k(MyDBContainer.ACCESS_TOKEN)
            _uiState.value = restaurantList
        }
    }
}