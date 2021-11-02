package com.daniillyubaev.ourawesomeapp.ui.signin

import androidx.lifecycle.viewModelScope
import com.daniillyubaev.ourawesomeapp.repository.AuthRepository
import com.daniillyubaev.ourawesomeapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SignInViewModel : BaseViewModel() {
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            AuthRepository.signIn(email, password)
        }
    }
}