package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.foodstore.component.TopAppBarWithBack
import com.example.foodstore.navigation.Screen
import com.example.foodstore.ui.theme.*
import com.example.foodstore.R

@Composable
fun RestoDetailsScreen(navController: NavController) {
    val pageCount by remember { mutableStateOf(0) }
    Scaffold(topBar = {
        TopAppBarWithBack(
            onBackClick = {
                navController.popBackStack()
                navController.navigate(Screen.HomeScreen.route)
            },
        )

    }, backgroundColor = bgwhitelight,
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {

                ConstraintLayout {
                    val (addtocartref) = createRefs()

                    Surface(color = ghost_white,
                        shape = RoundedCornerShape(40.dp)
                            .copy(
                                bottomStart = ZeroCornerSize,
                                bottomEnd = ZeroCornerSize
                            ), modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {

                            RestoTitleSubtitle(navController)
                            Spacer(modifier = Modifier.padding(10.dp))
                            Spacer(modifier = Modifier.padding(10.dp))
                            Divider(color = colorprimarywhite, thickness = 1.dp)
                            Spacer(modifier = Modifier.padding(20.dp))
                            Minuman()
                            Spacer(modifier = Modifier.padding(20.dp))
                            Makanan()
                            Spacer(modifier = Modifier.padding(20.dp))
//                            RestoAddToCartButton(navController)
                        }

                    }

                }
            }
        }
    )
}

@Preview
@Composable
fun RestoDetailsScreenPreview() = RestoDetailsScreen(NavController(LocalContext.current))

@Preview
@Composable
fun RestoTitleSubtitle(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Ayam Keprabon - GWALK",
            style = MaterialTheme.typography.h5,
            color = black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            backgroundColor = Color.White,
            shape = RoundedCornerShape(20.dp),elevation = 10.dp,
            modifier = Modifier
                .size(width = 400.dp, height = 200.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.padding(15.dp)
            ){
                Row(
//                    verticalAlignment = Alignment.Vertical.Top
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
                        modifier = Modifier.padding(10.dp,0.dp,100.dp,0.dp)
                    )
                    Text(
                        text = "Ratings dan Reviews",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = black,
                    )
                    IconButton(onClick = { navController.navigate(Screen.AddReviewScreen.route) }) {
                        Icon(
                            modifier = Modifier.size(18.dp, 18.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = black
                        )
                    }

                }
                Divider(
                    modifier = Modifier.padding(10.dp)
                )
                Row(){
                    Icon(imageVector = Icons.Default.LocationOn,
                        contentDescription = "",
                        tint = colorPrimary,
                        modifier = Modifier
                            .size(20.dp, 20.dp))
                    Text(
                        text = "Jl. Taman Palisade Manyar Gresik",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = black,
                        modifier = Modifier.padding(10.dp,0.dp,80.dp,0.dp)
                    )
                }
                Divider(
                    modifier = Modifier.padding(10.dp)
                )
                Row(){
                    Icon(imageVector = Icons.Default.Phone,
                        contentDescription = "",
                        tint = colorPrimary,
                        modifier = Modifier
                            .size(20.dp, 20.dp))
                    Text(
                        text = "+62 858 2136 4004",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = black,
                        modifier = Modifier.padding(10.dp,0.dp,80.dp,0.dp)
                    )
                }
                Divider(
                    modifier = Modifier.padding(10.dp)
                )
                Row(){
                    Icon(imageVector = Icons.Default.Create,
                        contentDescription = "",
                        tint = colorPrimary,
                        modifier = Modifier
                            .size(20.dp, 20.dp))
                    Text(
                        text = "Rate Us",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = black,
                        modifier = Modifier.padding(10.dp,0.dp,200.dp,0.dp)
                    )
                    IconButton(onClick = {

                    }) {
                        Icon(
                            modifier = Modifier.size(18.dp, 18.dp),
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = black
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun Makanan() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Makanan :",
            fontSize = 20.sp,
            color = black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider()
        Spacer(modifier = Modifier.height(10.dp))
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
                                    fontSize = 20.sp,
                                    color = black,
                                    fontWeight = FontWeight.Medium
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
                                    text = "Ayam yang dimasak dengan smokey charcoal",
                                    fontSize = 14.sp,
                                    color = black,
                                    fontWeight = FontWeight.Light
                                )
                            }
                            Row(){
                                Text(
                                    text = "Rp 50.000,00",
                                    fontSize = 14.sp,
                                    color = black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }

                }

            }
        }

    }
}

@Preview
@Composable
fun Minuman() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Minuman :",
            fontSize = 20.sp,
            color = black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider()
        Spacer(modifier = Modifier.height(10.dp))
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
                            painter = painterResource(R.drawable.blue_ocean),
                            contentDescription = "",
                        )
                        Column {
                            Row(){
                                Text(
                                    text = "Blue Ocean Squash",
                                    fontSize = 20.sp,
                                    color = black,
                                    fontWeight = FontWeight.Medium
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
                                    text = "4.2",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black,
                                )
                            }
                            Row(){
                                Text(
                                    text = "Minuman Terbaik dengan layer warna",
                                    fontSize = 14.sp,
                                    color = black,
                                    fontWeight = FontWeight.Light
                                )
                            }
                            Row(){
                                Text(
                                    text = "Rp 20.000,00",
                                    fontSize = 14.sp,
                                    color = black,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }

                }

            }
        }

    }
}

@Composable
fun RestoAddToCartButton(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.AddToCartScreen.route)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart",
                color = white,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = white,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp, 20.dp)
            )
        }
    }

}
@Preview
@Composable
fun RestoAddToCartButtonPreview() = RestoAddToCartButton(NavController(LocalContext.current))

@Composable
fun HeaderImagesSliderResto(pageCount: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Add to Cart",
            color = white,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview
@Composable
fun HeaderImagesSliderRestoPreview() = HeaderImagesSliderResto(3)

@Composable
fun PageIndicatorResto(pageCount: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(if (pageCount == 0) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 0) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 1) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 1) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 2) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 2) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 3) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 3) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 4) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 4) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 5) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 5) dark_gray else Color.LightGray)
            )

        }
    }

}

@Preview
@Composable
fun PageIndicatorRestoPreview() = PageIndicatorResto(3)