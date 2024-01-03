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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vp_alp.R

//sementara gini dulu wak, kalo ada tambahan dll nanti baru dirubah
private val Orange = Color(0xFFFFC107)
private val Abu = Color(0xFF747474)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFoodReviewsView() {
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

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
                            .clickable(
                                onClick = {
                                    //masi gatau
                                }
                            )
                    )
                    Text(
                        text = "My Food Reviews",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp)
                    )
                }
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                ){
                    item {
                        FoodReview()
                    }
                    item {
                        FoodReview()
                    }
                }
            }
        }
    )
}

@Composable
fun FoodReview(){
    Column {
        val namaresto = "Ayam Keprabon - Gwalk"
        val namamakanan = "Paket Indomie Geprek"
        val rating = 3
        val comment = "asu kirik elek cik restone ancene jaran kabeh"
        val harga = "30.000"
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){

            Image(
                painter = painterResource(id = R.drawable.geprek_matah),
                contentDescription ="Foto Resto",
                modifier = Modifier
                    .size(120.dp)
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
            )
            Column (
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ){
                Text(
                    text = "$namamakanan",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                )
                Text(
                    text = "Resto: ${namaresto}",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                )
                Text(
                    text = "$harga",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                )
            }
        }
        Row (
            modifier = Modifier
                .padding(bottom = 3.dp, start = 5.dp, top = 10.dp)
        ){
            Text(
                text = "Rating: ",
                color = Color.Black,
                fontSize = 14.sp,
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Bintang1",
                tint = Orange,
                modifier = Modifier
                    .size(20.dp)
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Bintang2",
                tint = if (rating >= 2) Orange else Abu,
                modifier = Modifier
                    .size(20.dp)
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Bintang3",
                tint = if (rating >= 3) Orange else Abu,
                modifier = Modifier
                    .size(20.dp)
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Bintang4",
                tint = if (rating >= 4) Orange else Abu,
                modifier = Modifier
                    .size(20.dp)
            )
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Bintang5",
                tint = if (rating >= 5) Orange else Abu,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Text(
            text = "Comments: ${comment}",
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 3.dp, start = 5.dp)
        )
        Divider(
            color = Abu,
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyFoodReviewsPreview() {
        MyFoodReviewsView()
}