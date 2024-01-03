package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.Category
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.RestoDetailUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.sql.Time

class RestoDetailViewModel : ViewModel() {
    val dummyFoodList: MutableList<Food> = mutableListOf(
        Food(
            id = 1,
            restaurant = Restaurant(
                id = 1,
                name = "Penjual Ayam",
                rating = 4.4,
                address = "123 Main Street",
                phone = "01234568",
                open_time = Time.valueOf("08:00:00"),
                close_time = Time.valueOf("20:00:00"),
                image = "https://example.com/restaurant_image.jpg"
            ),
            category = Category(
                id = 1,
                name = "Ayam"
            ),
            name = "Ayam Goreng Remaja",
            description = "Ini Dekripsi",
            price = 123.12,
            rating = 4.7,
            image = "https://example.com/food_image_sn.jpg"
        ),
        Food(
            id = 2,
            restaurant = Restaurant(
                id = 2,
                name = "Pasta Palace",
                rating = 4.2,
                address = "456 Pasta Street",
                phone = "98765432",
                open_time = Time.valueOf("11:30:00"),
                close_time = Time.valueOf("22:00:00"),
                image = "https://example.com/pasta_palace_image.jpg"
            ),
            category = Category(
                id = 2,
                name = "Pasta"
            ),
            name = "Spaghetti Bolognese",
            description = "Classic spaghetti with rich Bolognese sauce.",
            price = 14.99,
            rating = 4.5,
            image = "https://example.com/food_image_pasta.jpg"
        ),
        Food(
            id = 3,
            restaurant = Restaurant(
                id = 3,
                name = "Pizza Paradise",
                rating = 4.8,
                address = "789 Pizza Lane",
                phone = "56789012",
                open_time = Time.valueOf("12:00:00"),
                close_time = Time.valueOf("23:00:00"),
                image = "https://example.com/pizza_paradise_image.jpg"
            ),
            category = Category(
                id = 3,
                name = "Pizza"
            ),
            name = "Margherita Pizza",
            description = "Classic Margherita pizza with fresh tomatoes and mozzarella.",
            price = 12.99,
            rating = 4.9,
            image = "https://example.com/food_image_pizza.jpg"
        ),
        // Add more Food instances as needed
        // ...
    )
    val dummyBeverageList: MutableList<Food> = mutableListOf(
        Food(
            id = 1,
            restaurant = Restaurant(
                id = 1,
                name = "Penjual Ayam",
                rating = 4.4,
                address = "123 Main Street",
                phone = "01234568",
                open_time = Time.valueOf("08:00:00"),
                close_time = Time.valueOf("20:00:00"),
                image = "https://example.com/restaurant_image.jpg"
            ),
            category = Category(
                id = 1,
                name = "Ayam"
            ),
            name = "Ayam Goreng Remaja",
            description = "Ini Dekripsi",
            price = 123.12,
            rating = 4.7,
            image = "https://example.com/food_image_sn.jpg"
        ),
        Food(
            id = 2,
            restaurant = Restaurant(
                id = 2,
                name = "Pasta Palace",
                rating = 4.2,
                address = "456 Pasta Street",
                phone = "98765432",
                open_time = Time.valueOf("11:30:00"),
                close_time = Time.valueOf("22:00:00"),
                image = "https://example.com/pasta_palace_image.jpg"
            ),
            category = Category(
                id = 2,
                name = "Pasta"
            ),
            name = "Spaghetti Bolognese",
            description = "Classic spaghetti with rich Bolognese sauce.",
            price = 14.99,
            rating = 4.5,
            image = "https://example.com/food_image_pasta.jpg"
        ),
        Food(
            id = 3,
            restaurant = Restaurant(
                id = 3,
                name = "Pizza Paradise",
                rating = 4.8,
                address = "789 Pizza Lane",
                phone = "56789012",
                open_time = Time.valueOf("12:00:00"),
                close_time = Time.valueOf("23:00:00"),
                image = "https://example.com/pizza_paradise_image.jpg"
            ),
            category = Category(
                id = 3,
                name = "Pizza"
            ),
            name = "Margherita Pizza",
            description = "Classic Margherita pizza with fresh tomatoes and mozzarella.",
            price = 12.99,
            rating = 4.9,
            image = "https://example.com/food_image_pizza.jpg"
        ),
        // Add more Food instances as needed
        // ...
    )

    private val _uiState = MutableStateFlow(
        RestoDetailUIState(
            Restaurant(
                1,
                "Penjual Ayam",
                4.4,
                "address",
                "01234568",
                Time.valueOf("08:00:00"),
                Time.valueOf("20:00:00"),
                "https://example.com/restaurant_image.jpg",
            ),
            dummyFoodList,
            dummyBeverageList
        )
    )
    val uiState: StateFlow<RestoDetailUIState> = _uiState.asStateFlow()
}