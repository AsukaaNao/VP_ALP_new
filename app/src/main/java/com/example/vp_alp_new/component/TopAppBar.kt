package com.example.vp_alp_new.component

import androidx.compose.foundation.layout.*
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vp_alp_new.ui.theme.dark_gray

@Composable
fun TopAppBarWithBack(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "On Back",
                tint = dark_gray,
                modifier = Modifier.size(32.dp, 32.dp)

            )
        }

    }
}

@Preview
@Composable
fun TopAppBarWithBackPreview() = TopAppBarWithBack {}