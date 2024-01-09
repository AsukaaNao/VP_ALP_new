package com.example.vp_alp_new.ui.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R

import androidx.compose.runtime.*
import androidx.compose.material3.Divider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
//import com.example.vp_alp_new.data.loadReview
import com.example.vp_alp_new.model.Restaurant_review

import com.example.vp_alp_new.ui.viewModel.RestoReviewViewModel
import com.example.vp_alp_new.viewModel.NearMeViewModel



@Composable
fun reviewsandratingsResto(
    viewModel: RestoReviewViewModel = viewModel(),
    navController: NavController,
    id: Int
) {
    Log.d("Status", "Berhasil masuk review")
    val reviews by viewModel.uiState.collectAsState()

    LaunchedEffect(viewModel, id) {
        viewModel.loadData(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable {
                        // Navigate back when the arrow back is clicked
                        navController.popBackStack()
                    }
            )
            Text(
                text = "Reviews and ratings",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.weight(1f))

            var isLiked by remember { mutableStateOf(false) }

            Box(modifier = Modifier.clickable {
                isLiked = !isLiked
            }) {
                val tint = if (isLiked) Color(0xFFEC407A) else Color(0xFF636363)
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = tint
                )
            }


        }
        val context = LocalContext.current
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            reviews?.let { reviewList ->
                items(reviewList) { review ->
                    reviewCardResto(
                        review,
                        Modifier
                            .padding(4.dp),

                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }


        }


    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun reviewCardResto(rating:Restaurant_review, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(vertical = 8.dp)
//            .clickable {
//                Toast
//                    .makeText(context, "Do something", Toast.LENGTH_SHORT)
//                    .show()
//            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
                contentDescription = "image description",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(size = 40.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = rating.user.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    ), modifier = Modifier.padding(vertical = 5.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Rating:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000)
                        ), modifier = Modifier.padding(vertical = 5.dp)
                    )
                    var stars = rating.rating.toInt()
                    for (i in 1..stars) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_star_rate_24),
                            modifier = Modifier.size(20.dp),
                            contentDescription = ""
                        )
                    }
                }
            }

        }
        Text(
            text = "Comments: " + rating.content,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000)
            ), modifier = Modifier.padding(20.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray)
        )
    }

}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun reviewandratingsRestoPreview() {
//    reviewsandratingsResto(loadReview())
//
//}