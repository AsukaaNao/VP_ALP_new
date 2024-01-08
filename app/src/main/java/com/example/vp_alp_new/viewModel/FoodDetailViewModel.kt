package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodDetailViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        Food(
            1,
            "Ayam Goreng Remaja",
            "Ini Dekripsi",
            123.12,
            4.7,
            "sn"
        )
    )
    val uiState: StateFlow<Food> = _uiState.asStateFlow()
}