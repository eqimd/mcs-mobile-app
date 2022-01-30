package com.daniillyubaev.ourawesomeapp.data.network.response.error

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignInWithEmailErrorResponse(
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)