package com.daniillyubaev.ourawesomeapp.interactor

import com.daniillyubaev.ourawesomeapp.entity.User
import com.daniillyubaev.ourawesomeapp.repository.UsersRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class UsersInteractor @Inject constructor(
    private val usersRepository: UsersRepository
) {

    suspend fun loadUsers(): NetworkResponse<List<User>, Unit> =
        usersRepository.getUsers()
}