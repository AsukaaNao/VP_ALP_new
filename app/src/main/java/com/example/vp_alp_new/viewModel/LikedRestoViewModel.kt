package com.example.vp_alp_new.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LikedRestoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<near>?>(null)
    val uiState: StateFlow<List<near>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
            val restaurantList: List<near> =
                MyDBContainer().myDBRepositories.likedlist(MyDBContainer.ACCESS_TOKEN, MyDBContainer.user.id)
            _uiState.value = restaurantList
        }
    }
}