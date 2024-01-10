package com.example.vp_alp_new.ui.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WishListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<near>?>(null)
    val uiState: StateFlow<List<near>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
            val restaurantList: List<near> =
                MyDBContainer().myDBRepositories.all_resto2(MyDBContainer.ACCESS_TOKEN)
            _uiState.value = restaurantList
        }
    }

    fun isLikedResto(
        restaurant_id: Int
    ):Boolean {
        var bool = false
        viewModelScope.launch {
            Log.d("STep", "2")
            val user_id = MyDBContainer.user.id
            bool = MyDBContainer().myDBRepositories.isLikedResto(user_id, restaurant_id)
        }
        return bool
    }

    fun addFavResto(
        restaurant_id: Int
    ) {
        viewModelScope.launch {
            val user_id = MyDBContainer.user.id
            MyDBContainer().myDBRepositories.addFavResto(user_id, restaurant_id)
        }
    }

    fun deleteFavResto(
        restaurant_id: Int
    ) {
        viewModelScope.launch {
            Log.d("Step", "2")
            val user_id = MyDBContainer.user.id
            MyDBContainer().myDBRepositories.deleteFavResto(user_id, restaurant_id)
        }
    }
}