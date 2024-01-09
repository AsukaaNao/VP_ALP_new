package com.example.vp_alp_new.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.Food_review
import com.example.vp_alp_new.model.Restaurant_review
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FoodReviewViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<Food_review>?>(null)
    val uiState: StateFlow<List<Food_review>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
//            val reviewList: List<Food_review> =
//                MyDBContainer().myDBRepositories.getFoodReviews(MyDBContainer.ACCESS_TOKEN)
//            _uiState.value = reviewList
        }
    }
}