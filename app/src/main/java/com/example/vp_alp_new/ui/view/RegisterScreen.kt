package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.vp_alp_new.ui.ListScreen
import com.example.vp_alp_new.viewModel.RegisterViewModel

//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(
    viewModel: RegisterViewModel = viewModel(),
    navController: NavController
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
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = "Sign up to continue",
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

            var username by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var phone by rememberSaveable { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .padding(top = 80.dp)
            ) {
                CustomTextField1(
                    name = "Username",
                    value = username,
                    onValueChanged = { username = it },
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
                    name = "Email",
                    value = email,
                    onValueChanged = { email = it },
                    text = "",
                    keyboardOption = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
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
                        keyboardType = KeyboardType.Password,
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
                    name = "Phone",
                    value = phone,
                    onValueChanged = { phone = it },
                    text = "",
                    keyboardOption = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
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
                            viewModel.register(
                                username,
                                email,
                                password,
                                phone,
                                navController
                            )
                        }, // Make the Row clickable
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "REGISTER",
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
                        text = "Already have an account?",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB2B2B2),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Text(
                        text = "Sign In",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFF9F1C),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(ListScreen.Login.name)
                        }
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun RegisterPreview() {
//    RegisterView()
//}