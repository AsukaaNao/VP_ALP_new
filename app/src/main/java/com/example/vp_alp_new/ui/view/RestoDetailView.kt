package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.vp_alp.R
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.viewModel.RestoDetailViewModel

@Composable
fun RestoDetailView(
    viewModel: RestoDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
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
                    contentScale = ContentScale.None
                )
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }
        Text(
            text = uiState.restaurant.name,
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
                .shadow(
                    elevation = 2.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .width(321.dp)
                .padding(horizontal = 8.dp)
                .background(color = Color(0xFFECECEC), shape = RoundedCornerShape(size = 20.dp)),
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
                        text = "${uiState.restaurant.rating}",
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
                    verticalAlignment = Alignment.CenterVertically
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
                    text = uiState.restaurant.address,
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
                    text = uiState.restaurant.phone,
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
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Text(
                    text = "Makanan",
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
            items(uiState.foods) {
                FoodCard(food = it)
            }
            item {
                Text(
                    text = "Minuman",
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
            items(uiState.beverages) {
                FoodCard(food = it)
            }
        }
    }
}

@Composable
fun FoodCard(food: Food) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ajmere_dale_square_thumbnail),
            contentDescription = "image description",
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
                text = "${food.price}",
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

@Preview(showSystemUi = true)
@Composable
fun RestoDetailPreiew() {
    RestoDetailView()
}