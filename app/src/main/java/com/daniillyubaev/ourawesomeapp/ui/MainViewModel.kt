package com.daniillyubaev.ourawesomeapp.ui

import com.daniillyubaev.ourawesomeapp.repository.AuthRepositoryOld
import com.daniillyubaev.ourawesomeapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow

class MainViewModel : BaseViewModel() {
    val isAuthorizedFlow: Flow<Boolean> = AuthRepositoryOld.isAuthorizedFlow
}