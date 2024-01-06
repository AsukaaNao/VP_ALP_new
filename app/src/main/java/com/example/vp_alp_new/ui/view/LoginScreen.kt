package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.vp_alp.R
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.viewModel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    navController: NavController,
    dataStore: DataStoreManager
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9F1C))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Adjust padding as needed
        ) {
            Column(
                modifier = Modifier.padding(top = 94.dp, start = 32.dp)
            ) {
                Text(
                    text = "Sign In",
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = "Sign in to continue",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }

        // Place the third column on top of the background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(592.dp)
                .background(
                    color = Color(0xFFFFFFFF), shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {

//            val user by viewModel.uiState.collectAsState()

            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                CustomTextField1(
                    name = "Email",
                    value = email,
                    onValueChanged = { email = it },
                    text = "",
                    keyboardOption = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    ),
                )
                CustomTextField1(
                    name = "Password",
                    value = password,
                    onValueChanged = { password = it },
                    text = "",
                    keyboardOption = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    ),
                )
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .width(329.dp)
                        .height(56.dp)
                        .background(
                            color = Color(0xFFFF9F1C),
                            shape = RoundedCornerShape(size = 40.dp)
                        )
                        .clickable {
                            viewModel.ButtonLogin(
                                email,
                                password,
                                context,
                                navController,
                                dataStore
                            )
                        }, // Make the Row clickable
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "LOG IN",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Don’t have an account?",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB2B2B2),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Text(
                        text = "Sign Up",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFF9F1C),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField1(
    name: String,
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOption: KeyboardOptions,
    modifier: Modifier,
    colors: TextFieldColors
) {
    Column(
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        TextField(
            value = "$value",
            onValueChange = onValueChanged,
            label = {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFF9F1C),
                    )
                )
            },
            keyboardOptions = keyboardOption,
            modifier = modifier,
            colors = colors,
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                color = Color(0xFFB2B2B2),
            )
        )
    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}

