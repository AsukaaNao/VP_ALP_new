package com.example.vp_alp_new.viewModel


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.data.DataStoreManager
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {


    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun ButtonLogin(
        email: String,
        password: String,
        context: Context,
        navController: NavController,
        dataStore: DataStoreManager,
        onLoginError: (String) -> Unit // Callback to handle login errors
    ) {
        viewModelScope.launch {
            if (email.isEmpty() || password.isEmpty()) {
                onLoginError("Email and password cannot be empty")
                return@launch
            }

            // Validate email format
            if (!isValidEmail(email)) {
                onLoginError("Invalid email format")
                return@launch
            }

            val token = MyDBContainer().myDBRepositories.login(email, password)
            if (token.equals("Incorrect Password", true)) {
                onLoginError("Incorrect password")
            } else if (token.equals("User not found", true)) {
                onLoginError("User not found")
            } else {
                dataStore.saveToken(token)

                dataStore.getToken.collect { token ->
                    if (token != null) {
                        MyDBContainer.ACCESS_TOKEN = token

                        MyDBContainer.user = MyDBContainer().myDBRepositories.getUser(token)
                        //melihat token yang generated di log
                        Log.d("Token : ", MyDBContainer.ACCESS_TOKEN)
                        Log.d("USERNAME : ", MyDBContainer.user.toString())

                        navController.navigate(ListScreen.Home.name)
                    }
                }
            }
        }
    }
}