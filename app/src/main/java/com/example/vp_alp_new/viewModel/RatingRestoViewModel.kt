package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.launch

class RatingRestoViewModel: ViewModel() {
    fun makeNewReview(
        rating:Double,
        content: String,
        restaurant_id:Int,
        navController:NavController
    ) {
        viewModelScope.launch {
            val user_id = MyDBContainer.user.id
            MyDBContainer().myDBRepositories.createRestoReviews(rating, content, user_id, restaurant_id)

            navController.navigate(ListScreen.RestoReview.name+"/"+restaurant_id)
        }
    }
}