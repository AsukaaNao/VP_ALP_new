package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.launch

class RatingFoodViewModel: ViewModel() {
    fun makeNewReview(
        rating:Double,
        content: String,
        food_id:Int,
        navController: NavController
    ) {
        viewModelScope.launch {
            val user_id = MyDBContainer.user.id
            MyDBContainer().myDBRepositories.createFoodReviews(rating, content, user_id, food_id)

            navController.navigate(ListScreen.FoodReview.name+"/"+food_id)
        }
    }
}
