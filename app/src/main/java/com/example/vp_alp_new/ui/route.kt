package com.example.vp_alp_new.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.view.LoginScreen
import com.example.vp_alp_new.ui.view.landing
import com.example.vp_alp_new.ui.view.nearme
import com.example.vp_alp_new.viewModel.ListRestoUIState
import com.example.vp_alp_new.viewModel.ListRestoViewModel
import com.example.vp_alp_new.viewModel.LoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class ListScreen() {
    Account,
    AddRestoReview,
    AddFoodReview,
    EditAccount,
    FoodDetail,
    FoodReview,
    Home,
    Landing,
    LikedListResto,
    Login,
    NearMe,
    PopularList,
    Register,
    RestoDetail,
    RestoReview,
    SearchScreen,
    WishListResto,


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestoAppsRoute() {
    val navController = rememberNavController()
    val dataStore = DataStoreManager(LocalContext.current)

    GlobalScope.launch {
        dataStore.getToken.collect { token ->
            if (token != null) {
                MyDBContainer.ACCESS_TOKEN = token
            }
        }
    }
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListScreen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            //list screeen dibawah ini yaa


            composable(ListScreen.Account.name) {

            }

            composable(ListScreen.AddRestoReview.name) {

            }
            composable(ListScreen.AddFoodReview.name) {

            }

            composable(ListScreen.EditAccount.name) {

            }
            composable(ListScreen.FoodDetail.name) {

            }
            composable(ListScreen.FoodReview.name) {

            }
            composable(ListScreen.Home.name) {

            }
            composable(ListScreen.Landing.name) {
                landing()
            }

            composable(ListScreen.LikedListResto.name) {

            }


            composable(ListScreen.Login.name) {
                if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
                    val loginViewModel: LoginViewModel = viewModel()
                    LoginScreen(
//                        loginViewModel = loginViewModel,
                        navController = navController,
//                        dataStore = dataStore
                    )
                } else {
//                    navController.navigate(ListScreen.ListMovie.name) {
//                        popUpTo(ListScreen.Login.name) { inclusive = true }
//                    }
                }
            }
            composable(ListScreen.NearMe.name) {
                val listRestoViewModel: ListRestoViewModel = viewModel()
                val status = listRestoViewModel.listRestoUIState
                when (status) {
                    is ListRestoUIState.Loading -> {}
                    is ListRestoUIState.Success -> {}
//                        nearme(
                    //panggil api
//                        movieList = status.data,
//                        onFavClicked = {movie ->
//                            listMovieViewModel.onFavClicked(movie)
//                        },
//                        onCardClick = {
//                            navController.navigate(ListScreen.MovieDetail.name+"/"+it.id)
//                        },
//                        listRestoViewModel,
//                        navController,
//                        dataStore
//                    )
                    is ListRestoUIState.Error -> {}
                }
            }
            composable(ListScreen.PopularList.name) {

            }





            composable(ListScreen.Register.name) {
            }

            composable(ListScreen.RestoDetail.name) {

            }
            composable(ListScreen.RestoReview.name) {

            }
            composable(ListScreen.SearchScreen.name) {

            }

            composable(ListScreen.WishListResto.name) {

            }


//            composable(ListScreen.ListMovie.name){
//                val listMovieViewModel: ListMovieViewModel = viewModel()
//                val status = listMovieViewModel.listMovieUIState
//                when(status){
//                    is ListMovieUIState.Loading -> {}
//                    is ListMovieUIState.Success -> ListMovieView(
//                        movieList = status.data,
//                        onFavClicked = {movie ->
//                            listMovieViewModel.onFavClicked(movie)
//                        },
//                        onCardClick = {
//                            navController.navigate(ListScreen.MovieDetail.name+"/"+it.id)
//                        },
//                        listMovieViewModel,
//                        navController,
//                        dataStore
//                    )
//                    is ListMovieUIState.Error ->{}
//                }
//
//            }
//
//
//
//            composable(ListScreen.MovieDetail.name + "/{movieId}") {
//                val movieDetailViewModel: MovieDetailViewModel = viewModel()
//                movieDetailViewModel.getMovieById(
//                    it.arguments?.getString("movieId")!!.toInt()
//                )
//                val status = movieDetailViewModel.movieDetailUiState
//                when (status) {
//                    is MovieDetailUiState.Loading -> {}
//                    is MovieDetailUiState.Success -> {
//                        MovieDetailView(
//                            movie = status.data,
//                            onFavClicked = {}
//                        )
//                    }
//
//                    is MovieDetailUiState.Error -> {}
//                }
//            }
//            composable(ListScreen.Profile.name) {
//                ProfileView()
//            }
        }
    }
}