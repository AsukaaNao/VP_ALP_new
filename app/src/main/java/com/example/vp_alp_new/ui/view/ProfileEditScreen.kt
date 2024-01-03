package com.example.vp_alp_new.ui.view


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodstore.R
import com.example.foodstore.navigation.Screen
import com.example.foodstore.ui.theme.colorPrimary
import com.example.foodstore.ui.theme.colorprimarywhite
import com.example.foodstore.ui.theme.dark_gray
import com.example.foodstore.ui.theme.light_gray
import com.example.foodstore.ui.theme.white

@Composable
fun ProfileEditScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Edit Profile")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.ProfileScreen.route) }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Log Out")
                    }
                },
                backgroundColor = Color.Transparent
            )}
    ) { padding ->
        ProfileEditContent(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            ProfileEditLayout(navController)
        }
    }
}

@Preview
@Composable
fun ProfileEditContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}

@Preview
@Composable
fun ProfileEditLayout(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    Icon(
                        Icons.Filled.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {}

                Spacer(modifier = Modifier.padding(10.dp))

                // USERNAME
                Text(
                    text = "Username",
                    style = MaterialTheme.typography.subtitle1,
                    color = dark_gray,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 5.dp
                    )
                )

                var username by remember { mutableStateOf("") }

                TextField(
                    value = username,
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
                    label = { Text(text = "E-mail") },
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        username = it
                    }
                )

                // EMAIL
                Text(
                    text = "E-mail",
                    style = MaterialTheme.typography.subtitle1,
                    color = dark_gray,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 5.dp
                    )
                )

                var useremail by remember { mutableStateOf("") }

                TextField(
                    value = useremail,
                    leadingIcon = {
                        Row(
                            modifier = Modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Email,
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text(text = "christopherbrnby@gmail.com") },
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        useremail = it
                    }
                )

                // PASSWORD
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.subtitle1,
                    color = dark_gray,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 5.dp
                    )
                )

                var password by remember { mutableStateOf("") }

                TextField(
                    value = password,
                    leadingIcon = {
                        Row(
                            modifier = Modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
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
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text(text = "Password") },
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        password = it
                    }
                )

                // PHONE
                Text(
                    text = "Phone",
                    style = MaterialTheme.typography.subtitle1,
                    color = dark_gray,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 5.dp
                    )
                )

                var phone by remember { mutableStateOf("") }

                TextField(
                    value = phone,
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "+62...") },
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        phone = it
                    }
                )

                Button(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.ProfileScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 30.dp,
                            bottom = 34.dp
                        )
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Save",
                        color = white,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileEditScreenPreview() = ProfileEditScreen(NavController(LocalContext.current))