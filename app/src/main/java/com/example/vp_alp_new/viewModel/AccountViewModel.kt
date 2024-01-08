package com.example.vp_alp_new.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AccountViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<User?>(null)
    val uiState: StateFlow<User?> = _uiState.asStateFlow()

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
}