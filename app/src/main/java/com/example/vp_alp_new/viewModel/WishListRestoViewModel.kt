package com.example.vp_alp_new.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.Wishlist_restaurant
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.launch


sealed interface WishListRestoUIState{
    data class Success(val data: List<Wishlist_restaurant>):WishListRestoUIState
    object Error: WishListRestoUIState
    object Loading: WishListRestoUIState
}
class WishListFoodViewModel: ViewModel() {

    var wishListRestoUIState: WishListRestoUIState by mutableStateOf(WishListRestoUIState.Loading)
        private set

    private lateinit var data: List<Wishlist_restaurant>

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
    fun logout(
        navController: NavController,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.logout()
            dataStore.saveToken("")
            MyDBContainer.ACCESS_TOKEN = ""

            navController.navigate(ListScreen.Login.name){
                popUpTo(ListScreen.NearMe.name){inclusive = true}
            }}
    }
}
