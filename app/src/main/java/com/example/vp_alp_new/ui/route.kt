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
import com.example.vp_alp_new.viewModel.FoodReviewUIState
import com.example.vp_alp_new.viewModel.FoodReviewViewModel
import com.example.vp_alp_new.viewModel.ListRestoUIState
import com.example.vp_alp_new.viewModel.ListRestoViewModel
import com.example.vp_alp_new.viewModel.LoginViewModel
import com.example.vp_alp_new.viewModel.RestoReviewUIState
import com.example.vp_alp_new.viewModel.RestoReviewViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class ListScreen() {
    Account,
    AddRestoReview,
    AddFoodReview,
    Dashboard,
    EditAccount,
    FoodDetail,
    FoodReview,
    Home,
    Landing,
    LikedListResto,
    Login,
    NearMe,
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
            composable(ListScreen.Dashboard.name) {

            }

            composable(ListScreen.EditAccount.name) {

            }
            composable(ListScreen.FoodDetail.name) {

            }
            composable(ListScreen.FoodReview.name) {

                val foodReviewViewModel: FoodReviewViewModel = viewModel()
                val status = foodReviewViewModel.foodReviewUIState
                when (status) {
                    is FoodReviewUIState.Loading -> {}
                    is FoodReviewUIState.Success -> {}
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
                    is FoodReviewUIState.Error -> {}
                }

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
                    LoginScreen(
                        navController = navController,
                        dataStore = dataStore
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






            composable(ListScreen.Register.name) {
            }

            composable(ListScreen.RestoDetail.name) {

            }
            composable(ListScreen.RestoReview.name) {
                val restoReviewViewModel: RestoReviewViewModel = viewModel()
                val status = restoReviewViewModel.restoReviewUIState
                when (status) {
                    is RestoReviewUIState.Loading -> {}
                    is RestoReviewUIState.Success -> {}
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
                    is RestoReviewUIState.Error -> {}
                }
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