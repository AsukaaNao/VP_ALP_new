package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vp_alp.R
import com.example.vp_alp_new.model.Food
import com.example.vp_alp_new.viewModel.FoodDetailViewModel
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun foodDetailView(

    navController: NavController,onClose: () -> Unit, food: Food
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxSize())
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer(
                        clip = true,
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.background)
                    .padding(top = 27.dp, start = 27.dp, end = 27.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GlideImage(
                    model = food.image,
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x66000000),
                            ambientColor = Color(0x66000000)
                        )
                        .clip(RoundedCornerShape(size = 10.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .height(291.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        Modifier.weight(1f)
                    ) {
                        Text(
                            text = food.name,
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                    Text(
                        text = formatPrice(food.price),
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Right,
                        )
                    )
                }
                Text(
                    text = food.description,
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 13.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF848484),
                    )
                )
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Row(
                        Modifier.weight(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "image description",
                            contentScale = ContentScale.None
                        )
                        Text(
                            text = "${food.rating}",
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                // Perform an action when the box is clicked, e.g., call onClose()
                                onClose()
                            }
                    ) {
                        Text(
                            text = "Cancel",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 21.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF525252),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.padding(vertical = 21.dp, horizontal = 50.dp)
                        )
                    }
                    Text(
                        text = "Rate",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFF9F1C),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(vertical = 21.dp, horizontal = 50.dp)
                    )
                }
            }

            fun formatPrice(price: Double): String {
                val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()) as DecimalFormat
                numberFormat.applyPattern("#,###.###")
                return numberFormat.format(price)
            }
        }
    }
}

//@Preview
//@Composable
//fun foodDetailPreview() {
//    foodDetailView()
//}