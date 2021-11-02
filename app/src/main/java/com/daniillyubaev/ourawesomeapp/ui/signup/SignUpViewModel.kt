package com.daniillyubaev.ourawesomeapp.ui.signup

import androidx.lifecycle.viewModelScope
import com.daniillyubaev.ourawesomeapp.R
import com.daniillyubaev.ourawesomeapp.repository.AuthRepository
import com.daniillyubaev.ourawesomeapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SignUpViewModel : BaseViewModel() {
    fun signUp(
        firstname: String,
        lastname: String,
        nickname: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            AuthRepository.signUp(
                firstname,
                lastname,
                nickname,
                email,
                password
            )
        }
    }
}
