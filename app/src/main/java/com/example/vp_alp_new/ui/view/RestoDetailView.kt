package com.example.vp_alp_new.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vp_alp.R
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.viewModel.RestoDetailViewModel
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

@Composable
fun RestoDetailView(
    viewModel: RestoDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    id: Int,
    navController: NavController
) {
    val restaurant by viewModel.restaurant.collectAsState()
    val foods by viewModel.foods.collectAsState()
    Log.d("resto in view", restaurant.toString())

    Log.d("id in resto detail", id.toString())
    LaunchedEffect(viewModel, id) {
        Log.d("LaunchedEffect", "Triggered for id: $id")
        viewModel.fetchData(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                            modifier = Modifier .clickable {
                        // Navigate back when the arrow back is clicked
                        navController.popBackStack()
                    }
                )
            }
//            Image(
//                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
//                contentDescription = "image description",
//                contentScale = ContentScale.None
//            )
        }
        restaurant?.let { restaurant ->
            Text(
                text = restaurant.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(vertical = 13.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(
                        color = Color(0xFFECECEC),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .shadow(
                        elevation = 2.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                ) {
                    Row(
                        Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                        Text(
                            text = "${restaurant.rating}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF525252)
                            )
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            navController.navigate(ListScreen.RestoReview.name+"/"+id)
                        }
                    ) {
                        Text(
                            text = "Ratings and reviews",
                            style = TextStyle(
                                fontSize = 11.sp,
                                lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF525252),
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                    }
                }
                Divider(
                    Modifier
                        .padding(0.dp)
                        .width(291.dp)
                        .height(0.3.dp)
                        .background(color = Color(0xFF848484))
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                    Text(
                        text = restaurant.address,
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                }
                    Divider(
                        Modifier
                            .padding(0.dp)
                            .width(291.dp)
                            .height(0.3.dp)
                            .background(color = Color(0xFF848484))
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_local_phone_24),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                        Text(
                            text = restaurant.phone,
                            style = TextStyle(
                                fontSize = 11.sp,
                                lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                    }
            }
        }

        Divider(
            Modifier
                .padding(0.dp)
                .width(291.dp)
                .height(0.3.dp)
                .background(color = Color(0xFF848484))
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit_gray),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = "Rate Us",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.right_arrow),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Text(
                    text = "Menu",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier.padding(12.dp)
                )
            }
            item {
                Divider(
                    Modifier
                        .padding(0.dp)
                        .width(321.dp)
                        .height(0.3.dp)
                        .background(color = Color(0xFF848484))
                )
            }
            items(foods) {
                FoodCard(food = it)
            }
            item {
//                Text(
//                    text = "Minuman",
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        lineHeight = 21.sp,
//                        fontWeight = FontWeight(500),
//                        color = Color(0xFF000000),
//                    ),
//                    modifier = Modifier.padding(12.dp)
//                )
            }
            item {
                Divider(
                    Modifier
                        .padding(0.dp)
                        .width(321.dp)
                        .height(0.3.dp)
                        .background(color = Color(0xFF848484))
                )
            }
//            items(uiState.beverages) {
//                FoodCard(food = it)
//            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FoodCard(food: Food) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ajmere_dale_square_thumbnail),
//            contentDescription = "image description",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .size(119.dp)
//                .border(
//                    width = 1.dp,
//                    color = Color(0xFFFFFFFF),
//                    shape = RoundedCornerShape(size = 10.dp)
//                )
//                .shadow(
//                    elevation = 4.dp,
//                    spotColor = Color(0x66000000),
//                    ambientColor = Color(0x66000000)
//                )
//        )
        GlideImage(
            model = food.image,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(119.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x66000000),
                    ambientColor = Color(0x66000000)
                )
        )
        Column(
            Modifier.padding(start = 14.dp)
        ) {
            Text(
                text = food.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "${food.rating}",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                )
            }
            Text(
                text = food.description,
                style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 13.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF848484),
                )
            )
            Text(
                text = formatPrice(food.price),
                style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }
    }
}

fun formatPrice(price: Double): String {
    val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()) as DecimalFormat
    numberFormat.applyPattern("#.###")
    return numberFormat.format(price)
}

//@Preview(showSystemUi = true)
//@Composable
//fun RestoDetailPreiew() {
//    RestoDetailView()
//}