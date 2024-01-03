package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodstore.R
import com.example.foodstore.navigation.Screen
import com.example.foodstore.ui.theme.colorPrimary
import com.example.foodstore.ui.theme.colorprimarywhite

const val username = "Christoper"
const val email = "christoperbrnby@gmail.com"
const val phone = "08238762376"
const val my_description = "A group of simple, open source Android apps without ads " +
        "and unnecessary permissions, with materials design UI."

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Profile")
                },
//                navigationIcon = {
//                    IconButton(onClick = { }) {
//                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
//                    }
//                },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Log Out")
                    }
                },
                backgroundColor = Color.Transparent,
            )}
    ) { padding ->

        ProfileContent(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            TopProfileLayout(navController)
//            MainProfileContent()
            FooterContent(navController)
        }
    }
}

@Preview
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun TopProfileLayout(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = username,
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = email,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = phone,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                IconButton(onClick = { navController.navigate(Screen.ProfileEditScreen.route) }) {
                    Icon(imageVector = Icons.Filled.Create, contentDescription = "Edit")
                }
            }
        }
    }
}

@Preview
@Composable
fun MainProfileContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Popular",
                style = MaterialTheme.typography.h6,
            )

            Divider(modifier = Modifier.padding(vertical = 15.dp))

            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(
                        Icons.Rounded.List,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Repositories",
                        style = MaterialTheme.typography.h6,
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "24"
                    )
                }
            )
            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Starred",
                        style = MaterialTheme.typography.h6,
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "60"
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun GitContentItem(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    endItem: @Composable () -> Unit,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .weight(1f)
        ) {
            text()
        }
        endItem()
    }
}

@Preview
@Composable
fun FooterContent(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
//            Text(
//                modifier = Modifier
//                    .padding(10.dp),
//                text = "More Options",
//                style = MaterialTheme.typography.h5,
//            )
            MyFavResto(navController)
            Divider(
                modifier = Modifier.padding(10.dp)
            )

            MyWhistList(navController)
            Divider(
                modifier = Modifier.padding(10.dp)
            )

            SeeRestoReviews(navController)
            Divider(
                modifier = Modifier.padding(10.dp)
            )

            SeeFoodReviews(navController)
            Divider(
                modifier = Modifier.padding(10.dp)
            )

            ChangeLoc()
            Divider(
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview
@Composable
fun MyFavResto(navController: NavController) {
    Button(
        onClick = { navController.navigate(Screen.PopularListScreen.route) },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "My Favorite Resto",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun MyWhistList(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.PopularListScreen.route)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "My Whistlist",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun SeeRestoReviews(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.RestoReviewScreen.route)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "See restaurant reviews",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun SeeFoodReviews(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.MyRestoReviewScreen.route)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "See food reviews",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun ChangeLoc() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Change my location",
                    style = MaterialTheme.typography.subtitle1
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
@Preview
@Composable
fun ProfileScreenPreview() = ProfileScreen(NavController(LocalContext.current))