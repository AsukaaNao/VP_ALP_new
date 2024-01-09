package com.example.vp_alp_new.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<near>?>(null)
    private val _originalUiState = mutableListOf<near>()

    init {
        // Fetch the original list and store it for shuffling purposes
        viewModelScope.launch {
            _originalUiState.addAll(MyDBContainer().myDBRepositories.all_resto2(MyDBContainer.ACCESS_TOKEN))
            shuffleUiState()
        }
    }

    // Shuffle the UI state list
    private fun shuffleUiState() {
        _uiState.value = _originalUiState.shuffled()
    }

    // Computed property for accessing a shuffled UI state
    val uiState: StateFlow<List<near>?>
        get() = _uiState.asStateFlow()
}