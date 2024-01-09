package com.example.vp_alp_new.ui.viewModel
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

    fun addFavResto(
        restaurant_id: Int
    ) {
        viewModelScope.launch {
            val user_id = MyDBContainer.user.id
            MyDBContainer().myDBRepositories.addFavResto(user_id, restaurant_id)
        }
    }
}