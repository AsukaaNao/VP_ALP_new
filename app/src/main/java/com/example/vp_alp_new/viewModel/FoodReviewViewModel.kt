package com.example.vp_alp_new.viewModel


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.model.Food_review
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.Restaurant_review
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.launch


sealed interface FoodReviewUIState{
    data class Success(val data: List<Food_review>):FoodReviewUIState
    object Error: FoodReviewUIState
    object Loading: FoodReviewUIState
}
class FoodReviewViewModel: ViewModel() {
    var foodReviewUIState: FoodReviewUIState by mutableStateOf(FoodReviewUIState.Loading)
        private set

    private lateinit var data: List<Food_review>

    init{
        loadData()
    }

    fun loadData(){
//        viewModelScope.launch{
//            try {
//                data = MovieDBContainer().movieDBRepositories.getAllMovie(1)
//                listMovieUIState = ListMovieUIState.Success(data)
//            }catch(e: Exception){
//                Log.d("NetworkTest", e.message.toString())
//                listMovieUIState = ListMovieUIState.Error
//            }
//        }
    }

    fun onFavClicked(resto: Restaurant){
//        resto.isLiked = !resto.isLiked

        // sent server updated movie to server
    }


}