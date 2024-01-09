package com.example.vp_alp_new.ui.viewModel
import android.util.Log
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


    fun loadData(id: Int) {
        viewModelScope.launch {
            val reviewList: List<Restaurant_review> =
                MyDBContainer().myDBRepositories.getRestoReviews(MyDBContainer.ACCESS_TOKEN, id)
            _uiState.value = reviewList
            Log.d("List Review", reviewList.toString())
        }
    }
}