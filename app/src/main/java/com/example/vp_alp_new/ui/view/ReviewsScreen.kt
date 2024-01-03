package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodstore.navigation.Screen
import com.example.foodstore.ui.theme.colorprimarywhite
import com.example.foodstore.ui.theme.white
import com.example.foodstore.view.email
import com.example.foodstore.view.phone
import com.example.foodstore.view.username

@Preview
@Composable
fun ReviewsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Reviews and ratings")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.PopularListScreen.route) }) {
                        Icon(Icons.Outlined.Favorite, contentDescription = "Favorite")
                    }
                },
                backgroundColor = Color.Transparent,
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn {
                items(5) { review ->
                    ReviewItem()
                    Divider(
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ReviewItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
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
                        modifier = Modifier
                            .padding(bottom = 5.dp),
                        text = "Christopher",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Row {
                        Text(
                            text = "Rating: ",
                            style = MaterialTheme.typography.subtitle1
                        )
                        repeat(5) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = colorprimarywhite,
                            )
                        }
                    }
                }
            }

            Row {
                Text(
                    text = "Comments: ",
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Ayamnya enak, tempat bersih dan nyaman, pelayanan sangat baik.",
                    style = MaterialTheme.typography.body1
                )
            }

        }
    }
}