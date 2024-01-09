package com.example.vp_alp_new.viewModel

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.repository.MyDBContainer
import com.example.vp_alp_new.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<User?>(null)
    val uiState: StateFlow<User?> = _uiState.asStateFlow()
    private val _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin: LiveData<Boolean>
        get() = _navigateToLogin
    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                Log.d("User", "tes")
                Log.d("User", MyDBContainer().myDBRepositories.getUser(MyDBContainer.ACCESS_TOKEN).toString())
                MyDBContainer.user = MyDBContainer().myDBRepositories.getUser(MyDBContainer.ACCESS_TOKEN)
                _uiState.value = MyDBContainer.user
            } catch (e: Exception) {
                // Handle the exception (e.g., log or display an error message)
                e.printStackTrace()
            }
        }
    }

    fun logout() {
        // Clear the access token and reset user information
        MyDBContainer.ACCESS_TOKEN = "" // Clear the access token
        MyDBContainer.user = User() // Reset user information, assuming User() creates an empty user object

        // Clear the UI state
        _uiState.value = null

        // Set the flag to navigate to the login screen
        _navigateToLogin.value = true
    }
//
//    fun onLoginNavigated() {
//        // Call this when navigation to login is done
//        _navigateToLogin.value = false
//    }
}


