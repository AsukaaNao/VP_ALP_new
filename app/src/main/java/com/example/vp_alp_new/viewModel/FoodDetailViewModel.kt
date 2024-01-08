package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.Category
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.sql.Time
import java.time.LocalTime

class FoodDetailViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        Food(
            1,
            Restaurant(
                1,
                "Penjual Ayam",
                4.4,
                "address",
                "01234568",
                LocalTime.parse("08:00:00"),
                LocalTime.parse("20:00:00"),
                "https://example.com/restaurant_image.jpg"
            ),
            Category(
                1,
                "Ayam"
            ),
            "Ayam Goreng Remaja",
            "Ini Dekripsi",
            123.12,
            4.7,
            "sn"
        )
    )
    val uiState: StateFlow<Food> = _uiState.asStateFlow()
}