package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
//import com.example.foodstore.navigation.Screen
//import com.example.foodstore.ui.theme.black
//import com.example.foodstore.ui.theme.colorPrimary
//import com.example.foodstore.ui.theme.ghost_white
//import com.example.foodstore.ui.theme.white
//import com.example.foodstore.R
//import com.example.foodstore.ui.theme.bgwhitelight
//import com.example.foodstore.ui.theme.colorprimarywhite
//import com.example.foodstore.ui.theme.pink
import com.example.vp_alp.R
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun WishListScreenFood(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        ConstraintLayout {
            val (topappbarbgref, popularitemsref) = createRefs()

            Box(modifier = Modifier
                .height(100.dp)
                .constrainAs(topappbarbgref) {
                    top.linkTo(topappbarbgref.top)
                    bottom.linkTo(topappbarbgref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                HeaderHomeWishItems()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp)
                    .copy(bottomStart = ZeroCornerSize,
                        bottomEnd = ZeroCornerSize), modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .constrainAs(popularitemsref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {

                    WishItemsSection(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    WishItemsSection2(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    WishItemsSection3(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    WishItemsSection(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    WishItemsSection2(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    WishItemsSection3(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }


        }
    }
}

@Preview
@Composable
fun WishListScreenPreview() = WishListScreen(NavController(LocalContext.current))


@Composable
fun WishItemsSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navController.navigate(Screen.DetailsScreen.route)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(R.drawable.roasted),
                        contentDescription = "",
                    )
                    Column {
                        Row(){
                            Text(
                                text = "Ayam Keprabon",
                                fontSize = 24.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Icon(imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = colorPrimary,
                                modifier = Modifier
                                    .size(20.dp, 20.dp))
                            Text(
                                text = "4.6",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = black,
                            )
                        }
                        Row(){
                            Text(
                                text = "+62 858 2136 4004",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(){
                            Text(
                                text = "Jl. Taman Palisade Gresik Manyar",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }


                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(bgwhitelight)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            tint = pink,
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                        )
                    }

                }

            }

        }
    }
}

@Composable
fun WishItemsSection2(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navController.navigate(Screen.DetailsScreen.route)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(R.drawable.keprabon),
                        contentDescription = "",
                    )
                    Column {
                        Row(){
                            Text(
                                text = "Ayam Pop Tulang Lunak",
                                fontSize = 24.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Icon(imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = colorPrimary,
                                modifier = Modifier
                                    .size(20.dp, 20.dp))
                            Text(
                                text = "4.6",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = black,
                            )
                        }
                        Row(){
                            Text(
                                text = "+62 858 2136 4004",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(){
                            Text(
                                text = "Jl. Margoyoso Kertapati Manyar",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }


                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(bgwhitelight)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            tint = pink,
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                        )
                    }

                }

            }

        }
    }
}

@Composable
fun WishItemsSection3(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navController.navigate(Screen.DetailsScreen.route)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(R.drawable.nasgor),
                        contentDescription = "",
                    )
                    Column {
                        Row(){
                            Text(
                                text = "Nasgor Gila",
                                fontSize = 24.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Icon(imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = colorPrimary,
                                modifier = Modifier
                                    .size(20.dp, 20.dp))
                            Text(
                                text = "4.6",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = black,
                            )
                        }
                        Row(){
                            Text(
                                text = "+62 858 2136 4004",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row(){
                            Text(
                                text = "Jl. HR. Muhammad Depan POM",
                                fontSize = 16.sp,
                                color = black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }


                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(bgwhitelight)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "",
                            tint = pink,
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                        )
                    }

                }

            }

        }
    }
}

@Preview
@Composable
fun WishItemsSectionPreview() = WishItemsSection(NavController(LocalContext.current))

@Preview
@Composable
fun HeaderHomeWishItems() {
    Image(
        painter = painterResource(id = R.drawable.login_bg_white),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = black
            )
        }

        Text(
            text = "Wish List Foods",
            color = black,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = black
            )
        }

    }
}