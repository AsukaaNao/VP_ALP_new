package com.example.vp_alp_new.ui


import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.theme.colorPrimary
import com.example.vp_alp_new.ui.view.AccountView
import com.example.vp_alp_new.ui.view.DashboardSection
import com.example.vp_alp_new.ui.view.HomeView
import com.example.vp_alp_new.ui.view.LoginScreen
import com.example.vp_alp_new.ui.view.RegisterView
import com.example.vp_alp_new.ui.view.landing
import com.example.vp_alp_new.viewModel.FoodReviewUIState
import com.example.vp_alp_new.viewModel.FoodReviewViewModel
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


@Composable
fun BottomBar2(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
    navController: NavController
) {

    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = contentColorFor(MaterialTheme.colorScheme.background)
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            val iconRes = if (selected) section.selectedIcon else section.icon
            val iconColor = if (selected) colorPrimary else Color.Gray // Determine icon color

            BottomNavigationItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "Bottom nav icons",
                            tint = iconColor // Apply the determined color as tint
                        )
                        Text(
                            text = section.name,
                            color = if (selected) colorPrimary else Color.Gray
                        )
                    }
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = {
                    onSectionSelected (section)
                    when (section) {
                        DashboardSection.Home -> {
                            navController.navigate(ListScreen.Account.name)
                        }
                        DashboardSection.Search -> {
                            navController.navigate(ListScreen.Account.name)
                        }
                        DashboardSection.Favorite -> {
                            navController.navigate(ListScreen.Account.name)
                        }
                        DashboardSection.Profile -> {
                            navController.navigate(ListScreen.Login.name)
                        }
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestoAppsRoute() {
    val navController = rememberNavController()
    val dataStore = DataStoreManager(LocalContext.current)
    var bottomBarYes by remember { mutableStateOf(false) }

    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    GlobalScope.launch {
        dataStore.getToken.collect { token ->
            if (token != null) {
                MyDBContainer.ACCESS_TOKEN = token
            }
        }
    }
    Scaffold(
        bottomBar = {
            if (bottomBarYes) {
                BottomBar2(
                    items = navItems,
                    currentSection = sectionState.value,
                    onSectionSelected = { sectionState.value = it },
                    navController = navController
                )
            }
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value,
            label = ""
        ) { section ->
            when (section) {
                DashboardSection.Home -> ListScreen.Home.name
                DashboardSection.Search -> ListScreen.SearchScreen.name
//                DashboardSection.Search -> SearchingScreen(navController)
                DashboardSection.Favorite -> ListScreen.LikedListResto.name
                DashboardSection.Profile -> ListScreen.Account.name
            }
        }
        NavHost(
            navController = navController,
            startDestination = ListScreen.Register.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            //list screeen dibawah ini yaa


            composable(ListScreen.Account.name) {
                AccountView()
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
//                    navController.navigate(ListScreen.Home.name) {
//                        popUpTo(ListScreen.Login.name) { inclusive = true }
//                    }
                    bottomBarYes = true
                    LoginScreen(
                        navController = navController,
                        dataStore = dataStore
                    )
                }
            }
            composable(ListScreen.NearMe.name) {

            }






            composable(ListScreen.Register.name) {
                bottomBarYes = true
                RegisterView(navController = navController)
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