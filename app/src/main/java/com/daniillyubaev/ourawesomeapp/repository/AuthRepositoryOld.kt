package com.daniillyubaev.ourawesomeapp.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AuthRepositoryOld {

    private val _isAuthorizedFlow = MutableStateFlow(false)
    val isAuthorizedFlow = _isAuthorizedFlow.asStateFlow()

    suspend fun signIn(email: String, password: String) {
        _isAuthorizedFlow.emit(true)
    }

    suspend fun logout() {
        _isAuthorizedFlow.emit(false)
    }
}