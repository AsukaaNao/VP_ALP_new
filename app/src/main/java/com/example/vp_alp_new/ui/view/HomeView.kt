package com.example.vp_alp_new.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vp_alp.R

//import com.example.vp_alp_new.data.loadNear
import com.example.vp_alp_new.model.Restaurant
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.viewModel.HomeViewModel

private val Orange = Color(0xFFFF9F1C)
private val Kuning = Color(0xFFFFE456)

@Composable
fun HomeView(
    viewModel: HomeViewModel = viewModel(),
    navController: NavController,
) {
    val restaurants by viewModel.uiState.collectAsState()
    //tambahin sini tepher

    val backgound = listOf(Orange, Kuning)
    var searchresult by remember { mutableStateOf("") }

    // Shape for the search bar with rounded corners
    val shape: Shape = RoundedCornerShape(16.dp)
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                    backgound
                )
            )
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Rounded.LocationOn,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .clickable(
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                )
                Text(
                    text = "Denver Apartment",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                )
            }
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable(
                        onClick = {
                            navController.navigate(ListScreen.LikedListResto.name)
                        }
                    )
            )



        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp, bottom = 7.dp)
                .background(Color.White, RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Search icon
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Orange,
                modifier = Modifier.padding(start = 10.dp)
            )

            // Search TextField
            BasicTextField(
                value = searchresult,
                onValueChange = {
                    searchresult = it
//                    onSearch(it)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            // You can add a button here for additional actions if needed
        }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .padding(20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.__banner_bm_mbm_take_away_nasional2),
                contentDescription ="",
                modifier = Modifier
                    .width(400.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(bottom = 10.dp),
            )

            LazyVerticalGrid(
                modifier = Modifier.height(100.dp),
                columns = GridCells.Fixed(3),
            ){
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .clickable{
                                navController.navigate(ListScreen.NearMe.name)
                            }
                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.near),
                                contentDescription ="",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                            )
                            Text(
                                text = "Near Me",
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .clickable(
                                onClick = {
                                    //masi gatau
                                }
                            )
                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.bestseller),
                                contentDescription ="",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                            )
                            Text(
                                text = "Best Sellers",
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .clickable(
                                onClick = {
                                    //masi gatau
                                }
                            )
                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.screenshot_2023_11_25_160959),
                                contentDescription ="",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                            )
                            Text(
                                text = "Hemat <25k",
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
//                item {
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .height(100.dp)
//                            .width(100.dp)
//                            .padding(horizontal = 10.dp, vertical = 5.dp)
//                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    ){
//                        Column (
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ){
//                            Image(
//                                painter = painterResource(id = R.drawable.foods),
//                                contentDescription ="",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(70.dp)
//                            )
//                            Text(
//                                text = "Foods",
//                                fontWeight = FontWeight.Medium,
//                                fontSize = 12.sp
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .height(100.dp)
//                            .width(100.dp)
//                            .padding(horizontal = 10.dp, vertical = 5.dp)
//                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    ){
//                        Column (
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ){
//                            Image(
////                                painter = painterResource(id = R.drawable.drinks),
//                                painter = painterResource(id = R.drawable.foods),
//                                contentDescription ="",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(70.dp)
//                            )
//                            Text(
//                                text = "Drinks",
//                                fontWeight = FontWeight.Medium,
//                                fontSize = 12.sp
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        contentAlignment = Alignment.Center,
//                        modifier = Modifier
//                            .height(100.dp)
//                            .width(100.dp)
//                            .padding(horizontal = 10.dp, vertical = 5.dp)
//                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    ){
//                        Column (
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ){
//                            Image(
//                                painter = painterResource(id = R.drawable.bestseller),
//                                contentDescription ="",
//                                modifier = Modifier
//                                    .width(70.dp)
//                                    .height(70.dp)
//                            )
//                            Text(
//                                text = "Snacks",
//                                fontWeight = FontWeight.Medium,
//                                fontSize = 12.sp
//                            )
//                        }
//                    }
//                }
            }



            val context = LocalContext.current
            Column(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                restaurants?.forEach { item ->
                    // Buat elemen UI untuk setiap item dalam daftar
                    RestoCard(
                        item,
                        Modifier
                            .padding(4.dp),
                        navController = navController
                    )
                }

                    Spacer(modifier = Modifier.height(80.dp))


//                items(nearcardlist){
//                    RestoCard(
//                        it,
//                        Modifier
//                            .padding(4.dp)
//
//                    )
//                }
//                item {
//                    Spacer(modifier = Modifier.height(80.dp))
//                }

            }
        }






    }
}












//@Preview
//@Composable
//fun homePreview() {
//    val navController = rememberNavController()
//
//    HomeView(
//        loadNear(),
//        navController = navController,
//        onNearClick = {
//            navController.navigate(ListScreen.NearMe.name)
//        }
//    )
//}