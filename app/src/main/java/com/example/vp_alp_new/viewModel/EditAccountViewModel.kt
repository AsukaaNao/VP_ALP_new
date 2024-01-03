package com.example.vp_alp_new.viewModel

import androidx.lifecycle.ViewModel
import com.example.vp_alp_new.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EditAccountViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(
        User(
            1,
            "Christopher",
            "01234567",
            "test@fake.com",
            "sabdkja"
        )
    )
    val uiState: StateFlow<User> = _uiState.asStateFlow()
}