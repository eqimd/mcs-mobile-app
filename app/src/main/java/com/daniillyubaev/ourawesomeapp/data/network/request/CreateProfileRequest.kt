package com.daniillyubaev.ourawesomeapp.data.network.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateProfileRequest(
    @Json(name = "user_name") val username: String,
    @Json(name = "first_name") val firstname: String,
    @Json(name = "last_name") val lastname: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)