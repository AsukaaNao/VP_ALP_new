package com.example.vp_alp_new.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vp_alp_new.viewModel.RatingFoodViewModel
import com.example.vp_alp_new.viewModel.RatingRestoViewModel

//sementara gini dulu wak, kalo ada tambahan dll nanti baru dirubah
private val Orange = Color(0xFFFFC107)
private val Abu = Color(0xFF747474)
private val Abumuda = Color(0xFF9C9C9C)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingFoodFormsView(
    viewModel: RatingFoodViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    modifier: Modifier = Modifier,
    stars: Int = 5,
    starsColor: Color = Orange,
    id: Int,
    navController :NavController
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    var value by remember { mutableStateOf("") }
    var rating by remember{
        mutableDoubleStateOf(0.0)
    }
//    Log.d("Rating", rating.toString())
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 10.dp, start = 5.dp, end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Text(
                        text = "Rate",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ){
                    for (index in 1 .. stars){
                        Icon (
                            modifier = modifier.clickable{ rating = index.toDouble() },
                            contentDescription = null,
                            tint =
                            if (index <= rating){
                                starsColor
                            }
                            else{
                                Abumuda
                            },
                            imageVector = Icons.Rounded.Star
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Comments",
                        color = Orange,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                    )
                    TextField(
                        value = value,
                        onValueChange = { newText ->
                            value = newText
                        },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                        modifier = Modifier.width(300.dp)
                    )

                    Button(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 200.dp),
                        onClick = {
                            viewModel.makeNewReview(
                                rating = rating,
                                content = value,
                                food_id = id,
                                navController = navController
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Orange,)
                    ) {
                        Text("SEND")
                    }


                }
            }
        }
    )
}





//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RatingFoodFormsPreview() {
//        var rating_1 by remember{
//            mutableDoubleStateOf(0.0)
//        }
//        RatingFoodFormsView(
//            modifier = Modifier.size(50.dp),
//            rating = rating_1,
//        ){
//            rating_1 = it
//        }
//}