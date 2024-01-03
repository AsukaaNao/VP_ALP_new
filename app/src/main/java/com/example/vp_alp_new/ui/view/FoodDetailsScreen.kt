package com.example.vp_alp_new.ui.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
//import com.example.foodstore.component.TopAppBarWithBack
//import com.example.foodstore.navigation.Screen
//import com.example.foodstore.ui.theme.*
//import com.example.foodstore.R
import com.example.vp_alp.R
import com.example.vp_alp_new.component.TopAppBarWithBack
import com.example.vp_alp_new.ui.theme.bgwhitelight
import com.example.vp_alp_new.ui.theme.black
import com.example.vp_alp_new.ui.theme.colorPrimary
import com.example.vp_alp_new.ui.theme.colorprimarywhite
import com.example.vp_alp_new.ui.theme.dark_gray
import com.example.vp_alp_new.ui.theme.ghost_white
import com.example.vp_alp_new.ui.theme.white
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun FoodDetailsScreen(navController: NavController) {
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
                    val (imagesliderref, addtocartref) = createRefs()
                    Box(modifier = Modifier
                        .height(280.dp)
                        .constrainAs(imagesliderref) {
                            top.linkTo(imagesliderref.top)
                            bottom.linkTo(imagesliderref.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                        HeaderImagesSlider(pageCount)
                    }
                    Surface(color = ghost_white,
                        shape = RoundedCornerShape(40.dp)
                            .copy(
                                bottomStart = ZeroCornerSize,
                                bottomEnd = ZeroCornerSize
                            ), modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            FoodTitleSubtitle()
                            Spacer(modifier = Modifier.padding(10.dp))
                            AddtoCartPrice()
                            Spacer(modifier = Modifier.padding(10.dp))
                            Divider(color = colorprimarywhite, thickness = 1.dp)
                            Spacer(modifier = Modifier.padding(20.dp))
                            FoodAbout()
                            Spacer(modifier = Modifier.padding(20.dp))
                            FoodAddToCartButton(navController)
                        }

                    }

                }
            }
        }
    )
}

@Preview
@Composable
fun FoodDetailsScreenPreview() = FoodDetailsScreen(NavController(LocalContext.current))

@Preview
@Composable
fun FoodTitleSubtitle() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Ayam Keprabon - GWALK",
            style = MaterialTheme.typography.h5,
            color = black
        )
        Text(
            text = "Rp 56700.00",
            color = black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun AddtoCartPrice() {
    val counter = remember {
        mutableStateOf(1)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Box(
            modifier = Modifier
                .width(110.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .background(colorPrimary)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
                        contentDescription = "Minus Items",
                        modifier = Modifier.padding(bottom = 15.dp),
                        tint = white
                    )
                }

                Text(
                    text = "${counter.value}",
                    color = white,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                IconButton(onClick = {
                    counter.value++
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Items",
                        tint = white,
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun FoodAbout() {
    Column(modifier = Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Ayam bakar yang dimasak dengan cara smokey roasted \n" +
                    "Kamu dapat menikmatinya selagi hangat dan juga dengan cocolan sambal \n" +
                    "Waktu persiapan hidangan ini kurang lebih 1,5 Jam",
            style = MaterialTheme.typography.body2,
            color = black
        )
    }
}

@Composable
fun FoodAddToCartButton(navController: NavController) {
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
fun FoodAddToCartButtonPreview() = FoodAddToCartButton(NavController(LocalContext.current))

@Composable
fun HeaderImagesSlider(pageCount: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)
    ) {

        Box(modifier = Modifier.fillMaxHeight()) {

            Image(
                painter = painterResource(id = R.drawable.roasted),
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp)
            )
        }


    }
    PageIndicatorFood(pageCount)
}

@Preview
@Composable
fun HeaderImagesSliderPreview() = HeaderImagesSlider(3)

@Composable
fun PageIndicatorFood(pageCount: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
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
fun PageIndicatorFoodPreview() = PageIndicatorFood(3)