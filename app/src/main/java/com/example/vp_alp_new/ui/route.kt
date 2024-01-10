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
import androidx.compose.runtime.mutableDoubleStateOf
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
//import com.example.vp_alp_new.data.loadNear
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.theme.colorPrimary
import com.example.vp_alp_new.ui.view.AccountView
import com.example.vp_alp_new.ui.view.DashboardSection
import com.example.vp_alp_new.ui.view.Dibawah25kView
import com.example.vp_alp_new.ui.view.FoodReview
import com.example.vp_alp_new.ui.view.HomeView
import com.example.vp_alp_new.ui.view.LikedListView
import com.example.vp_alp_new.ui.view.LoginScreen
import com.example.vp_alp_new.ui.view.MyFoodReviewsView
import com.example.vp_alp_new.ui.view.MyRestoReviewsView
import com.example.vp_alp_new.ui.view.RatingFoodFormsView
import com.example.vp_alp_new.ui.view.RatingRestoFormsView
import com.example.vp_alp_new.ui.view.RegisterView
import com.example.vp_alp_new.ui.view.RestoDetailView
import com.example.vp_alp_new.ui.view.SearchingScreen
import com.example.vp_alp_new.ui.view.WishListView
import com.example.vp_alp_new.ui.view.bestSellerView
import com.example.vp_alp_new.ui.view.foodDetailView
import com.example.vp_alp_new.ui.view.nearmeView
import com.example.vp_alp_new.ui.view.reviewsandratingsFood
import com.example.vp_alp_new.ui.view.reviewsandratingsResto
import com.example.vp_alp_new.ui.viewModel.FoodReviewViewModel

//import com.example.vp_alp_new.viewModel.RestoReviewUIState
//import com.example.vp_alp_new.viewModel.RestoReviewViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class ListScreen() {
    Account,
    AddRestoReview,
    AddFoodReview,
    BestSeller,
    EditAccount,
    FoodReview,
    Home,
    LikedListResto,
    Login,
    NearMe,
    Register,
    RestoDetail,
    RestoReview,
    SearchScreen,
    WishListResto,
    Dibawah25k,
    MyRR,
    MyFR


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
                    onSectionSelected(section)
                    when (section) {
                        DashboardSection.Home -> {
                            navController.navigate(ListScreen.Home.name)
                        }

                        DashboardSection.Search -> {
                            navController.navigate(ListScreen.SearchScreen.name)
                        }

                        DashboardSection.Favorite -> {
                            navController.navigate(ListScreen.LikedListResto.name+"/"+MyDBContainer.user.id)
                        }

                        DashboardSection.Profile -> {
                            navController.navigate(ListScreen.Account.name)
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
    var bottomBarYes by remember { mutableStateOf(true) }

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
            startDestination = ListScreen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            //list screeen dibawah ini yaa


            composable(ListScreen.Account.name) {
                bottomBarYes = true
                AccountView(navController = navController)
            }

            composable(ListScreen.AddRestoReview.name + "/{id}") {
                bottomBarYes = true
                val id = it.arguments?.getString("id")!!.toInt()
                RatingRestoFormsView(
                    modifier = Modifier.size(50.dp),
                    id = id,
                    navController = navController
                )
            }
            composable(ListScreen.AddFoodReview.name + "/{id}") {
                bottomBarYes = true
                val id = it.arguments?.getString("id")!!.toInt()
                RatingFoodFormsView(
                    modifier = Modifier.size(50.dp),
                    id = id,
                    navController = navController
                )
            }

            composable(ListScreen.BestSeller.name) {
                bottomBarYes = true
                bestSellerView(navController = navController)
            }

            composable(ListScreen.Dibawah25k.name) {
                bottomBarYes = true
                Dibawah25kView(navController = navController)
            }

            composable(ListScreen.EditAccount.name) {
                bottomBarYes = true
            }
            composable(ListScreen.MyRR.name+"/{id}") {
                bottomBarYes = true
                MyRestoReviewsView(navController = navController)

            }
            composable(ListScreen.MyFR.name+"/{id}") {
                bottomBarYes = true
                MyFoodReviewsView(navController = navController)
            }



            composable(ListScreen.FoodReview.name+"/{id}") {

                bottomBarYes = true
                val id = it.arguments?.getString("id")!!.toInt()
                reviewsandratingsFood(
                    navController = navController,
                    id = id
                )
            }
            composable(ListScreen.Home.name) {
                bottomBarYes = true
                HomeView(
                    navController = navController
                )
            }


            composable(ListScreen.LikedListResto.name+"/{id}") {
                bottomBarYes = true
                LikedListView(navController = navController)
            }


            composable(ListScreen.Login.name) {
                if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
                    bottomBarYes = false
                    LoginScreen(
                        navController = navController,
                        dataStore = dataStore
                    )
                } else {
//                    navController.navigate(ListScreen.Home.name) {
//                        popUpTo(ListScreen.Login.name) { inclusive = true }
//                    }
                    bottomBarYes = false
                    LoginScreen(
                        navController = navController,
                        dataStore = dataStore
                    )
                }
            }
            composable(ListScreen.NearMe.name) {
                bottomBarYes = true
                nearmeView(navController = navController)
            }





            composable(ListScreen.Register.name) {
                bottomBarYes = false
                RegisterView(navController = navController)
            }

            composable(ListScreen.RestoDetail.name + "/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")!!.toInt()
                bottomBarYes = true
                RestoDetailView(
                    id = id,
                    navController = navController
                )
            }
            composable(ListScreen.RestoReview.name + "/{id}") {
                bottomBarYes = true
                val id = it.arguments?.getString("id")!!.toInt()
                reviewsandratingsResto(
                    navController = navController,
                    id = id
                )
            }

            composable(ListScreen.SearchScreen.name) {
                bottomBarYes = true
                SearchingScreen(navController = navController)
            }

            composable(ListScreen.WishListResto.name) {
                bottomBarYes = true
                WishListView(navController = navController)
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