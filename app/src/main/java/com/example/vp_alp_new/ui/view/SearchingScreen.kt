package com.example.vp_alp_new.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.vp_alp.R

//import com.example.vp_alp_new.data.loadNear
import com.example.vp_alp_new.model.near
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.ui.viewModel.LikedRestoViewModel
import com.example.vp_alp_new.ui.viewModel.SearchViewModel

private val Orange = Color(0xFFFF9F1C)
private val Kuning = Color(0xFFFFE456)
private val LightGray = Color(0xFFCFCFCF)

@Composable
fun SearchingScreen(
    viewModel: SearchViewModel = viewModel(),
    navController: NavController,
) {
    val restaurants by viewModel.uiState.collectAsState()
    //tambahin sini tepher

    val backgound = listOf(Orange, Kuning)
    var searchresult by remember { mutableStateOf("") }

    // Shape for the search bar with rounded corners
    val shape: Shape = RoundedCornerShape(16.dp)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                    backgound
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Icon(
//                    imageVector = Icons.Rounded.LocationOn,
//                    contentDescription = "Back",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .padding(horizontal = 5.dp)
//                        .clickable(
//                            onClick = {
//                                //masi gatau
//                            }
//                        )
//                )
                Text(
                    text = "Flover",
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

            LazyRow(
                modifier = Modifier.padding(5.dp)
            ) {
                item {
                    Text(
                        text = "Near Me",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(LightGray, RoundedCornerShape(5.dp))
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(ListScreen.NearMe.name)
                            }
                    )
                }
                item {
                    Text(
                        text = "Best Sellers",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(LightGray, RoundedCornerShape(5.dp))
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(ListScreen.BestSeller.name)
                            }
                    )
                }
                item {
                    Text(
                        text = "Hemat <25k",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .background(LightGray, RoundedCornerShape(5.dp))
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(ListScreen.Dibawah25k.name)
                            }
                    )
                }
//                item {
//                    Text(
//                        text = "Foods",
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier
//                            .padding(horizontal = 5.dp)
//                            .background(LightGray, RoundedCornerShape(5.dp))
//                            .padding(10.dp)
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    )
//                }
//                item {
//                    Text(
//                        text = "Drinks",
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier
//                            .padding(horizontal = 5.dp)
//                            .background(LightGray, RoundedCornerShape(5.dp))
//                            .padding(10.dp)
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    )
//                }
//                item {
//                    Text(
//                        text = "Snacks",
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier
//                            .padding(horizontal = 5.dp)
//                            .background(LightGray, RoundedCornerShape(5.dp))
//                            .padding(10.dp)
//                            .clickable(
//                                onClick = {
//                                    //masi gatau
//                                }
//                            )
//                    )
//                }
            }

            val context = LocalContext.current
            if (searchresult == null) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                ) {

                    restaurants?.let { restaurantList ->
                        items(restaurantList) { restaurant ->

                            RestoCard(
                                restaurant,
                                Modifier
                                    .padding(4.dp),
                                navController
                            )

                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                ) {

                    restaurants?.let { restaurantList ->
                        items(restaurantList) { restaurant ->
                            if (restaurant.name.uppercase().contains(searchresult.uppercase()) ||
                                restaurant.address.uppercase().contains(searchresult.uppercase())
                            ) {
                                RestoCard(
                                    restaurant,
                                    Modifier
                                        .padding(4.dp),
                                    navController
                                )
                            }
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }


        }


    }


}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SearchingScreenPreview(){
//    SearchingScreen(loadNear())
//
//}


//package com.example.vp_alp_new.ui.view
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.ZeroCornerSize
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.BlendMode.Companion.Screen
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.widget.ConstraintLayout
////import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.navigation.NavController
////import com.example.foodstore.ui.theme.*
////import com.example.foodstore.R
////import com.example.foodstore.navigation.Screen
//import com.example.vp_alp_new.ui.ListScreen
//import com.example.vp_alp_new.ui.theme.black
//import com.example.vp_alp_new.ui.theme.colorPrimary
//import com.example.vp_alp_new.ui.theme.ghost_white
//import com.example.vp_alp_new.ui.theme.white
//
////@Preview(showBackground = true)
//@Composable
//fun SearchingScreen(navController:NavController?) {
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .verticalScroll(rememberScrollState())) {
////        ConstraintLayout {
////            val (cartitemsbgref, checkoutref) = createRefs()
////
////            Box(modifier = Modifier
////                .height(100.dp)
////                .constrainAs(cartitemsbgref) {
////                    top.linkTo(cartitemsbgref.top)
////                    bottom.linkTo(cartitemsbgref.top)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
////                }) {
////                HeaderCartSearchingItems(navController)
////            }
////
////            Surface(color = ghost_white,
////                shape = RoundedCornerShape(40.dp).copy(bottomStart = ZeroCornerSize,
////                    bottomEnd = ZeroCornerSize), modifier = Modifier
////                    .padding(top = 70.dp)
////                    .constrainAs(checkoutref) {
////                        bottom.linkTo(parent.bottom)
////                        start.linkTo(parent.start)
////                        end.linkTo(parent.end)
////                    }) {
////                Column(modifier = Modifier
////                    .fillMaxSize()
////                    .padding(20.dp))
////                {
////                    ButtonGroup(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang2(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang2(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang2(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang2(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
////                    ItemsBarang2(navController)
////                    Spacer(modifier = Modifier.padding(10.dp))
//////                    Spacer(modifier = Modifier.padding(20.dp))
//////                    ApplyCoupons()
//////                    Spacer(modifier = Modifier.padding(10.dp))
//////                    CheckoutDetailss()
////                }
////            }
////        }
//    }
//}
//
////@Preview
//@Composable
//fun HeaderCartSearchingItems(navController: NavController?) {
////    Image(
////        painter = painterResource(id = R.drawable.login_bg),
////        contentDescription = "login bg",
////        contentScale = ContentScale.FillWidth,
////        modifier = Modifier.fillMaxSize()
////    )
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        IconButton(onClick = {
//            navController?.navigate(ListScreen.Home.name)
//        }) {
//            Icon(
//                modifier = Modifier.size(32.dp, 32.dp),
//                imageVector = Icons.Default.KeyboardArrowLeft,
//                contentDescription = "",
//                tint = white
//            )
//        }
//
//        Text(
//            text = "Search Items",
//            color = white,
//            modifier = Modifier.padding(end = 150.dp),
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//        )
//    }
//}
//
////@Preview
//@Composable
//fun ItemsBarang(navController: NavController?) {
//
//    Box(modifier = Modifier
//        .fillMaxWidth()
//        .wrapContentHeight()
//        .clip(RoundedCornerShape(16.dp))
//        .background(white)) {
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(10.dp)) {
//            Box(
//                modifier = Modifier
//                    .weight(0.3f)
//                    .height(70.dp)
//                    .clip(RoundedCornerShape(12.dp)),
//            ) {
////                Image(
////                    modifier = Modifier
////                        .size(70.dp),
////                    painter = painterResource(R.drawable.keprabon),
////                    contentDescription = "",
////                )
//            }
//
//            Column(
//                verticalArrangement = Arrangement.SpaceEvenly,
//                horizontalAlignment = Alignment.Start,
//                modifier = Modifier
//                    .weight(0.9f)
//                    .wrapContentHeight()
//            ) {
//                IconButton(onClick = {
////                    navController?.navigate(Screen.RestoDetailsScreen.route)
//                }) {
//                    Text(
//                        text = "Ayam Keprabon - GWalk",
//                        fontSize = 16.sp,
//                        color = black,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                ) {
//                    Icon(imageVector = Icons.Default.Star,
//                        contentDescription = "",
//                        tint = colorPrimary,
//                        modifier = Modifier
//                            .size(20.dp, 20.dp))
//                    Text(
//                        text = "4.6",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = black,
//                    )
//                }
//                Text(
//                    text = "+62 858 2136 4004",
//                    fontSize = 16.sp,
//                    color = black,
//                )
//                Text(
//                    text = "Jl. Taman Niagara Lestari 24",
//                    fontSize = 16.sp,
//                    color = black,
//                )
//
//            }
//        }
//    }
//}
//
////@Preview
//@Composable
//fun ItemsBarang2(navController: NavController?) {
//    Box(modifier = Modifier
//        .fillMaxWidth()
//        .wrapContentHeight()
//        .clip(RoundedCornerShape(16.dp))
//        .background(white)) {
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(10.dp)) {
//            Box(
//                modifier = Modifier
//                    .weight(0.3f)
//                    .height(70.dp)
//                    .clip(RoundedCornerShape(12.dp)),
//            ) {
////                Image(
////                    modifier = Modifier
////                        .size(70.dp),
////                    painter = painterResource(R.drawable.roasted),
////                    contentDescription = "",
////                )
//            }
//
//            Column(
//                verticalArrangement = Arrangement.SpaceEvenly,
//                horizontalAlignment = Alignment.Start,
//                modifier = Modifier
//                    .weight(0.9f)
//                    .wrapContentHeight()
//            ) {
//                IconButton(onClick = {
////                    navController?.navigate(Screen.RestoDetailsScreen.route)
//                }) {
//                    Text(
//                        text = "Ayam Lodoho - GWalk",
//                        fontSize = 16.sp,
//                        color = black,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                ) {
//                    IconButton(
//                        modifier = Modifier.size(20.dp),
//                        onClick = {
////                            navController?.navigate(Screen.RestoReviewScreen.route)
//                        }) {
//                        Icon(
//                            imageVector = Icons.Default.Star,
//                            contentDescription = "",
//                            tint = colorPrimary,
//                            modifier = Modifier
//                                .size(20.dp, 20.dp)
//                        )
//                    }
//                    IconButton(
//                        modifier = Modifier.size(20.dp),
//                        onClick = {
////                            navController?.navigate(Screen.RestoReviewScreen.route)
//                        }) {
//                        Text(
//                            text = "4.6",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = black,
//                        )
//                    }
//                }
//                Text(
//                    text = "+62 858 2136 4004",
//                    fontSize = 16.sp,
//                    color = black,
//                )
//                Text(
//                    text = "Jl. HR. Muhammd No. 24",
//                    fontSize = 16.sp,
//                    color = black,
//                )
//            }
//        }
//    }
//}
//
////@Preview
//@Composable
//fun ButtonGroup(navController: NavController?){
//    Row (
//        modifier = Modifier.padding(
//            horizontal = 0.dp,
//            vertical = 5.dp
//        ),
//    ) {
//        var searchfield by remember { mutableStateOf("") }
//
////        TextField(
////            value = searchfield,
////            leadingIcon = {
////                Row(
////                        modifier = Modifier.wrapContentWidth(),
////                    verticalAlignment = Alignment.CenterVertically,
////                    content = {
////                        IconButton(
////                            modifier = Modifier.size(24.dp),
////                            onClick = {
////                                navController?.navigate(Screen.SearchScreen.route)
////                            }) {
////                            Icon(
////                                imageVector = Icons.Default.Search,
////                                contentDescription = "Search",
////                                tint = colorPrimary,
////                                modifier = Modifier.size(24.dp, 24.dp)
////                            )
////                        }
////                        Canvas(
////                            modifier = Modifier
////                                .height(24.dp)
////                                .padding(start = 10.dp)
////                        ) {
//////                            drawLine(
//////                                color = light_gray,
////                                start = Offset(0f, 0f),
////                                end = Offset(0f, size.height),
////                                strokeWidth = 2.0F
////                            )
////                        }
////
////                    }
////                )
////            },
//////            colors = TextFieldDefaults.textFieldColors(
////                backgroundColor = white,
////                focusedIndicatorColor = Color.Transparent,
////                unfocusedIndicatorColor = Color.Transparent,
////                disabledIndicatorColor = Color.Transparent
////            ),
////            modifier = Modifier
////                .fillMaxWidth(),
////            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
////            label = { Text(text = "Comments") },
////            shape = RoundedCornerShape(8.dp),
////            onValueChange = {
////                searchfield = it
////            }
////        )
//
////    }
////    Row(
////        modifier = Modifier
////            .fillMaxWidth(),
////        horizontalArrangement = Arrangement.SpaceBetween,
////        verticalAlignment = Alignment.CenterVertically
////    ) {
//
////        IconButton(onClick = {
////            navController?.navigate(Screen.NearMeScreen.route)
////        }) {
////            ButtonGroup(
////                onClick = {
////
////                },
////                colors = ButtonDefaults.buttonColors(backgroundColor = dark_gray),
////                modifier = Modifier
////                    .padding(
////                        top = 4.dp,
////                        bottom = 4.dp
////                    ),
////                shape = RoundedCornerShape(8.dp)
////            ) {
////                Text(
////                    text = "Near Me",
////                    color = white,
////                    style = MaterialTheme.typography.button,
////                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
////                )
////            }
////        }
//
////        IconButton(onClick = {
////            navController?.navigate(Screen.PopularListScreen.route)
////        }) {
////            Button(
////                onClick = {
////
////                },
////                colors = ButtonDefaults.buttonColors(backgroundColor = dark_gray),
////                modifier = Modifier
////                    .padding(
////                        top = 4.dp,
////                        bottom = 4.dp
////                    ),
////                shape = RoundedCornerShape(8.dp)
////            ) {
////                Text(
////                    text = "Best Seller",
////                    color = white,
////                    style = MaterialTheme.typography.button,
////                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
////                )
////            }
////        }
//
////        IconButton(onClick = {
////            navController?.navigate(Screen.SearchScreen.route)
////        }) {
////            Button(
////                onClick = {
////
////                },
////                colors = ButtonDefaults.buttonColors(backgroundColor = dark_gray),
////                modifier = Modifier
////                    .padding(
////                        top = 4.dp,
////                        bottom = 4.dp
////                    ),
////                shape = RoundedCornerShape(8.dp)
////            ) {
////                Text(
////                    text = "Hemat < 25K",
////                    color = white,
////                    style = MaterialTheme.typography.button,
////                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
////                )
////            }
////        }
//
//
//    }
//}