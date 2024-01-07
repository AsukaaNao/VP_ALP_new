package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.User
import com.example.vp_alp_new.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<User>(
        User(
            1,
            "Christopher",
            "01234567",
            "test@fake.com",
            "sabdkja"
        )
    )
    val uiState: StateFlow<User> = _uiState.asStateFlow()

    init {
        _uiState.value = MyDBContainer.user
    }
}