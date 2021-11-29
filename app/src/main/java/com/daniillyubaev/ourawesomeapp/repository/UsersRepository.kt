package com.daniillyubaev.ourawesomeapp.repository

import com.daniillyubaev.ourawesomeapp.data.network.Api
import com.daniillyubaev.ourawesomeapp.entity.User
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val api: Api
) {

    suspend fun getUsers(): NetworkResponse<List<User>, Unit> =
        api.getUsers()
}