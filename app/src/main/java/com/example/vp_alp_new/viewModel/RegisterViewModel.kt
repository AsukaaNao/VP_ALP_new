package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    fun register(
        username: String,
        email:String,
        password: String,
        phone: String,
        navController: NavController
    ) {
        viewModelScope.launch {

             MyDBContainer().myDBRepositories.register(username, email, password, phone)

            navController.navigate(ListScreen.Login.name)
        }
    }
}