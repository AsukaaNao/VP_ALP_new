package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vp_alp.R

//import com.example.vp_alp_new.data.loadNear
import com.example.vp_alp_new.model.near

@Composable
fun LikedListView(
    nearcardlist:List<near>,
    navController: NavController
) {
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
                modifier = Modifier.padding(end=16.dp)
            )
            Text(
                text = "Favourite",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )

        }
        val context = LocalContext.current
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
        ) {
            items(nearcardlist){
                RestoCard(
                    it,
                    Modifier
                        .padding(4.dp),
                    navController = navController
                )
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }


        }





    }
}

















//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LikedListPreview(){
//    LikedListView(loadNear())
//
//}