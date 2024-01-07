package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NearMeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<Restaurant>?>(null)
    val uiState: StateFlow<List<Restaurant>?> = _uiState.asStateFlow()

    init {
        
    }
}