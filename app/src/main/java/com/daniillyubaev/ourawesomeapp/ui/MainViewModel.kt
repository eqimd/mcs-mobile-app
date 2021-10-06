package com.daniillyubaev.ourawesomeapp.ui

import com.daniillyubaev.ourawesomeapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : BaseViewModel() {
    val isAuthorizedFlow: Flow<Boolean> = MutableStateFlow(false)
}