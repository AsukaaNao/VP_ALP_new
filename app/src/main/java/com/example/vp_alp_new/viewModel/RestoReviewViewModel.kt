package com.example.vp_alp_new.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.Restaurant_review
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestoReviewViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<Restaurant_review>?>(null)
    val uiState: StateFlow<List<Restaurant_review>?> = _uiState.asStateFlow()

    init {
//        getRestaurantsData()
        viewModelScope.launch {
            val reviewList: List<Restaurant_review> =
                MyDBContainer().myDBRepositories.getRestoReviews(MyDBContainer.ACCESS_TOKEN)
            _uiState.value = reviewList
        }
    }
}