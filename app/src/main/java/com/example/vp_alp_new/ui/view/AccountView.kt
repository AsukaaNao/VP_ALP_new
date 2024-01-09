package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vp_alp.R
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.viewModel.AccountViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AccountView(
    viewModel: AccountViewModel = viewModel(),
    navController: NavController,
) {
    val user by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "My Account",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            LogoutButton(navController = navController, accountViewModel = viewModel)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ajmere_dale_square_thumbnail),
//                contentDescription = "image description",
//                modifier = Modifier
//                    .size(58.dp)
//                    .clip(CircleShape),
//                contentScale = ContentScale.Crop
//            )
            GlideImage(
                model = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
                contentDescription = "image description",
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
                    .weight(1f)
            ) {
                user?.let {
                    Text(
                        text = it.name,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            //                        fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )
                    Text(
                        text = it.email,
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB2B2B2),
                        )
                    )
                    Text(
                        text = it.phone,
                        style = TextStyle(
                            fontSize = 11.sp,
                            lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB2B2B2),
                        )
                    )
                }
            }
            Column {
                Image(
                    painter = painterResource(id = R.drawable.baseline_edit_24),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }
        template(text = "My Favourite Resto",onClick ={navController.navigate(ListScreen.LikedListResto.name)})
        template(text = "My Wishlist", onClick = { navController.navigate(ListScreen.WishListResto.name) })
        template(text = "See restaurant reviews",onClick ={navController.navigate(ListScreen.RestoReview.name) })
        template(text = "See food reviews",onClick ={navController.navigate(ListScreen.FoodReview.name)})
//        template(text = "Change my location",onClick ={})
    }
}

@Composable
fun template(
    text: String,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable(onClick = onClick) // Adding clickable behavior
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF525252)
                )
            )
        }
        Column {
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
            .width(326.dp)
            .height(0.3.dp)
            .background(color = Color(0xFFB2B2B2))
    )
}

@Composable
fun LogoutButton(navController: NavController, accountViewModel: AccountViewModel) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .size(24.dp)
            .clickable {
                accountViewModel.logout()
                navController.navigate(ListScreen.Login.name)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.exit),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AccountPreview() {
//    AccountView()
//}