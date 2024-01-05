package com.example.vp_alp_new.ui.view

import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.CanFocusChecker.end
import androidx.compose.ui.node.CanFocusChecker.start
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.volley.toolbox.ImageRequest
import com.example.foodstore.R
import com.example.foodstore.navigation.Screen
import com.example.foodstore.ui.theme.*
import com.example.vp_alp.R
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.ui.theme.black
import com.example.vp_alp_new.ui.theme.colorPrimary
import com.example.vp_alp_new.ui.theme.ghost_white
import com.example.vp_alp_new.ui.theme.light_gray
import com.example.vp_alp_new.ui.theme.pink
import com.example.vp_alp_new.ui.theme.white
import com.squareup.picasso.Picasso
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(navController: NavController) {
    val pageCount by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {

            val (logoimageref, loginformref) = createRefs()

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                HeaderHome(navController)
            }

            var useremail by remember { mutableStateOf("") }


            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    AutoScrollImageCarousel(imageList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
//                    ImageCarousel(imageList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
                    Spacer(modifier = Modifier.padding(10.dp))
                    Spacer(modifier = Modifier.padding(20.dp))
                    CategoryView(navController)
                    Spacer(modifier = Modifier.padding(10.dp))
                    PopularItemSection(navController)
                    Spacer(modifier = Modifier.padding(10.dp))

                }

            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() = HomeScreen(NavController(LocalContext.current))

@Preview
@Composable
fun HeaderHome(navController: NavController?) {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row (
            modifier = Modifier.padding(
                horizontal = 30.dp,
                vertical = 5.dp
            ),
        ) {
            var searchfield by remember { mutableStateOf("") }

            TextField(
                value = searchfield,
                leadingIcon = {
                    Row(
//                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            IconButton(
                                modifier = Modifier.size(24.dp),
                                onClick = {
//                                    navController?.navigate(ListScreen.SearchScreen.route)
                                }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = colorPrimary,
                                    modifier = Modifier.size(24.dp, 24.dp)
                                )
                            }
                            Canvas(
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(start = 10.dp)
                            ) {
                                drawLine(
                                    color = light_gray,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height),
                                    strokeWidth = 2.0F
                                )
                            }

                        }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Comments") },
                shape = RoundedCornerShape(8.dp),
                onValueChange = {
                    searchfield = it
                }
            )

        }

//        IconButton(onClick = { }) {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = "Search",
//                tint = white,
//                modifier = Modifier.size(32.dp, 32.dp)
//            )
//
//        }

    }
}

@Composable
fun AutoScrollImageCarousel(imageList: List<Int>) {
    var currentIndex by remember { mutableStateOf(0) }

    // Use LaunchedEffect to start an effect when the composable is first laid out
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Adjust the delay time as needed (e.g., 3000 milliseconds for 3 seconds)
            currentIndex = (currentIndex + 1) % imageList.size
        }
    }

    ImageCarousel(imageList = imageList, currentIndex = currentIndex)
}

@Composable
fun ImageCarousel(imageList: List<Int>, currentIndex: Int) {
    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(imageList) { imageResId ->
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(8.dp)
//                    .graphicsLayer {
//                        // Apply scaling to the current image to make it stand out
//                        scale= if (currentIndex == currentListIndex) 1.2f else 1f
//                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AutoScrollImageCarouselPreview() {
    AutoScrollImageCarousel(imageList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
}

//@Composable
//fun ImageCarousel(imageList: List<Int>) {
//    val lazyListState = rememberLazyListState()
//
//    LazyRow(
//        state = lazyListState,
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        items(imageList) { imageResId ->
//            Image(
//                painter = painterResource(id = imageResId),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(200.dp)
//                    .padding(8.dp)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ImageCarouselPreview() {
//    ImageCarousel(imageList = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3))
//}

@Composable
fun CategoryView(navController : NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(){
            CategoryButton(
                icon = painterResource(id = R.drawable.location),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
            Text(text = "Near Me", style = MaterialTheme.typography.caption)
        }

        Column() {
            CategoryButton(
                icon = painterResource(id = R.drawable.best),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
            Text(text = "Best Seller", style = MaterialTheme.typography.caption)
        }
        Column() {
            CategoryButton(
                icon = painterResource(id = R.drawable.coin),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
            Text(text = "Hemat < 25K", style = MaterialTheme.typography.caption)
        }

    }
    Spacer(modifier = Modifier.padding(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
        ) {
            CategoryButton(
                icon = painterResource(id = R.drawable.food),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
            Text(text = "Foods", style = MaterialTheme.typography.caption)
        }

        Column() {
            CategoryButton(
                icon = painterResource(id = R.drawable.drinks),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
            Text(text = "Drink", style = MaterialTheme.typography.caption)
        }
        Column() {
            CategoryButton(
                icon = painterResource(id = R.drawable.snack),
                backgroundColor = Color(0xffFFFFFF),
                navController = navController
            )
//            Text(text = "Snacks", style = MaterialTheme.typography.caption)
        }

    }

}

@Composable
fun CategoryButton(
    icon: Painter,
    backgroundColor: Color,
    navController: NavController
) {
    IconButton(onClick = {
//        navController.navigate(Screen.NearMeScreen.route)
    }) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(18.dp)
        ) {
            Image(
                painter = icon, contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}

@Preview
@Composable
fun CategoryButtonPreview() = CategoryButton(
    painterResource(id = R.drawable.snack),
    Color(0xffFFFFFF),
    navController = rememberNavController()
)

@Composable
fun PopularItemSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
//        Text(text = "Popular Items", style = MaterialTheme.typography.h6)
//        TextButton(onClick = {
//            navController.navigate(Screen.PopularListScreen.route)
//        }) {
//            Text(text = "View All", color = colorPrimary)
//        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
    PopularItems(navController)
    Spacer(modifier = Modifier.padding(10.dp))
    PopularItems(navController)
}

@Preview
@Composable
fun PopularItemSectionPreview() = PopularItemSection(NavController(LocalContext.current))

@Composable
fun PopularItems(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(white)
//                .clickable { navController.navigate(Screen.DetailsScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .size(120.dp),
                        painter = painterResource(R.drawable.roasted),
                        contentDescription = "",
                    )
                    Column(
                    ) {
                        IconButton(
                            onClick = {
//                                navController.navigate(Screen.RestoDetailsScreen.route)
                            }) {
                            Text(
                                text = "Ayam Keprabon - GWalk",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = black,
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            IconButton(
                                modifier = Modifier.size(20.dp),
                                onClick = {
//                                    navController.navigate(Screen.RestoReviewScreen.route)
                                }) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "",
                                    tint = colorPrimary,
                                    modifier = Modifier
                                        .size(20.dp, 20.dp)
                                )
                            }
                            IconButton(
                                modifier = Modifier.size(20.dp),
                                onClick = {
//                                    navController.navigate(Screen.RestoReviewScreen.route)
                                }) {
                                Text(
                                    text = "4.6",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black,
                                )
                            }
                        }

                        Text(
                            text = "+62 812345688",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black,
                        )
                        Text(
                            text = "Jl. Taman Palisade Grobogan Jawa Timur",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black,
                        )
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
                                    .background(ghost_white)
                                    .padding(4.dp)
                                    .shadow(elevation = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                IconButton(onClick = {
//                                    navController.navigate(Screen.PopularListScreen.route)
                                }) {
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

                Spacer(modifier = Modifier.height(16.dp))

            }
        }
        Spacer(modifier = Modifier.width(16.dp))

    }
}

@Preview
@Composable
fun PopularItemsPreview() = PopularItems(NavController(LocalContext.current))



