package com.example.vp_alp_new.ui.view

import android.widget.RatingBar
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonColors
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import com.example.foodstore.R
//import com.example.foodstore.models.ReviewViewModel
//import com.example.foodstore.navigation.Screen
//import com.example.foodstore.ui.theme.colorPrimary
//import com.example.foodstore.ui.theme.dark_gray
//import com.example.foodstore.ui.theme.light_gray
//import com.example.foodstore.ui.theme.white
//import com.example.foodstore.view.FooterContent
//import com.example.foodstore.view.ProfileContent
//import com.example.foodstore.view.TopProfileLayout
import com.example.vp_alp.R
import com.example.vp_alp_new.ui.theme.colorPrimary
import com.example.vp_alp_new.ui.theme.dark_gray
import com.example.vp_alp_new.ui.theme.light_gray
import com.example.vp_alp_new.ui.theme.white
import com.example.vp_alp_new.viewModel.ReviewVMAxel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddReviewScreen(
    viewModel: ReviewVMAxel,
    navController: NavController
) {
    var rating by remember { mutableStateOf(0) }
    var reviewText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Text("Rate")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.RestoDetailsScreen.route) }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
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
            Column (
            ) {
                // Rating
                RatingBar(
                    rating = rating,
                    onRatingChanged = { newRating ->
                        rating = newRating
                    }
                )
            }


            // Comment Text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Comments",
                style = MaterialTheme.typography.subtitle1,
                color = dark_gray,
                modifier = Modifier.padding(
                    top = 10.dp,
                    bottom = 5.dp
                )
            )

            var comments by remember { mutableStateOf("") }

            TextField(
                value = comments,
                leadingIcon = {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                tint = colorPrimary
                            )
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
                    comments = it
                }
            )

//        OutlinedTextField(
//            value = reviewText,
//            onValueChange = { newReviewText ->
//                reviewText = newReviewText
//            },
//            label = { Text("Write your review") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Done
//            ),
//            onImeActionPerformed = { action, controller ->
//                if (action == ImeAction.Done) {
//                    controller?.hideSoftwareKeyboard()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(120.dp)
//        )

            // Submit Button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                onClick = {
                    navController.navigate(Screen.ReviewsScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Send",
                    color = white)
            }
        }
    }

}
@Preview
@Composable
fun RatingBar(
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..5) {
            val icon = if (i <= rating) {
                painterResource(id = R.drawable.favourites)
            } else {
                painterResource(id = R.drawable.star_outline)
            }
            IconButton(
                onClick = { onRatingChanged(i) },
            ) {
                Icon(painter = icon, contentDescription = null)
            }
        }
    }
}