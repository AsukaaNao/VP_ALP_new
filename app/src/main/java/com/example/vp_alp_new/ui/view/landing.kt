package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vp_alp.R
import kotlinx.coroutines.delay
import androidx.activity.ComponentActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources.Theme
import android.os.Bundle
import android.os.PersistableBundle
import android.window.SplashScreen

import androidx.activity.compose.setContent


@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }

    }
}

@Preview
@Composable
private fun SplashScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )



    }
}

//
//
//
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = null,
//            modifier = Modifier.size(300.dp)
//        )
//
//
//
//    }
//    LaunchedEffect(true) {
//        delay(3000) // Change the duration as needed
//        navigateToNextScreen()
//    }
//
//
//}
////@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun landingPreview(){
//    landing()
//
//}