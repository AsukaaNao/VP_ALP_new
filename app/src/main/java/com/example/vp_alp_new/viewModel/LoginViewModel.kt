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

    fun ButtonLogin(
        email: String,
        password: String,
        context: Context,
        navController: NavController,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            val token = MyDBContainer().myDBRepositories.login(email, password)
            if (token.equals("Incorrect Password", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else if (token.equals("User not found", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else {
                dataStore.saveToken(token)

                dataStore.getToken.collect { token ->
                    if (token != null) {
                        MyDBContainer.ACCESS_TOKEN = token

                        MyDBContainer.user = MyDBContainer().myDBRepositories.getUser(token)
                        //melihat token yang generated di log
                        Log.d("Token : ", MyDBContainer.ACCESS_TOKEN)
                        Log.d("USERNAME : ", MyDBContainer.user.toString())

                        navController.navigate(ListScreen.Account.name)
                    }
                }
            }
        }
    }
}