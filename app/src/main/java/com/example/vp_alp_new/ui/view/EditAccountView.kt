package com.example.vp_alp_new.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.vp_alp.R
import com.example.vp_alp_new.viewModel.EditAccountViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun EditAccView(
    viewModel: EditAccountViewModel = viewModel()
) {

    val user by viewModel.uiState.collectAsState()

    var username by rememberSaveable { mutableStateOf(user.name) }
    var email by rememberSaveable { mutableStateOf(user.email) }
    var phone by rememberSaveable { mutableStateOf(user.phone) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Text(
                text = "Edit Account",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 21.sp,
//                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .width(24.dp)
                    .height(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ajmere_dale_square_thumbnail),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }
        CustomTextField(
            name = "Username",
            value = username,
            onValueChanged = { username = it },
            text = user.name,
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
        CustomTextField(
            name = "Email",
            value = email,
            onValueChanged = { email = it },
            text = user.email,
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

        CustomTextField(
            name = "Phone",
            value = phone,
            onValueChanged = { phone = it },
            text = user.phone,
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
        CustomSubmitButton()
//        Row(
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .width(329.dp)
//                .height(56.dp)
//                .background(color = Color(0xFFFF9F1C), shape = RoundedCornerShape(size = 40.dp))
//                .clickable { showPasswordDialog() },
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "SAVE",
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 21.sp,
////                fontFamily = FontFamily(Font(R.font.inter)),
//                    fontWeight = FontWeight(600),
//                    color = Color(0xFFFFFFFF),
//                    textAlign = TextAlign.Center,
//                )
//            )
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSubmitButton() {
    // State to remember whether the dialog is showing or not
    val showDialog = rememberSaveable { mutableStateOf(false) }

    // State to remember the entered password
    val passwordState = rememberSaveable { mutableStateOf("") }

    // Function to show the AlertDialog
    fun showPasswordDialog() {
        showDialog.value = true
    }

    // Function to handle the positive button click (Save)
    fun onPositiveClick() {
        // Handle the password input, you can perform validation or save the password here
        // For now, just print the entered password
        println("Entered Password: ${passwordState.value}")
        // Dismiss the dialog
        showDialog.value = false
    }

    Row(
        modifier = Modifier
            .padding(top = 30.dp)
            .width(329.dp)
            .height(56.dp)
            .background(color = Color(0xFFFF9F1C), shape = RoundedCornerShape(size = 40.dp))
            .clickable { showPasswordDialog() }, // Make the Row clickable
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SAVE",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            )
        )
    }

    // Show AlertDialog if showDialog is true
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = {
                Text(
                    text = "Confirm",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 21.sp,
//                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            },
            text = {
                TextField(
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it },
                    label = {
                        Text(
                            text = "Enter your password",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 21.sp,
//                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF525252),
                            )
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onPositiveClick()
                    },
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    },
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background)
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    name: String,
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOption: KeyboardOptions,
    modifier: Modifier,
    colors: TextFieldColors
) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
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
//                fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF525252),
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditAccPreview() {
    EditAccView()
}