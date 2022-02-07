package com.daniillyubaev.ourawesomeapp.data.network.response.error

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateProfileErrorResponse(
    @Json(name = "non_field_errors") val nonFieldErrors: String,
    @Json(name = "verification_token") val verificationToken: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)
