package com.daniillyubaev.ourawesomeapp.data.network

import com.daniillyubaev.ourawesomeapp.data.network.request.CreateProfileRequest
import com.daniillyubaev.ourawesomeapp.data.network.request.RefreshAuthTokensRequest
import com.daniillyubaev.ourawesomeapp.data.network.request.SignInWithEmailRequest
import com.daniillyubaev.ourawesomeapp.data.network.response.VerificationTokenResponse
import com.daniillyubaev.ourawesomeapp.data.network.response.error.*
import com.daniillyubaev.ourawesomeapp.entity.AuthTokens
import com.daniillyubaev.ourawesomeapp.entity.Post
import com.daniillyubaev.ourawesomeapp.entity.User
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.*

interface Api {

    @GET("users")
    suspend fun getUsers(): NetworkResponse<List<User>, Unit>

    @POST("auth/sign-in-with-email")
    suspend fun signInWithEmail(
        @Body request: SignInWithEmailRequest
    ): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse>

    @POST("auth/refresh-tokens")
    suspend fun refreshAuthTokens(
        @Body request: RefreshAuthTokensRequest
    ): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse>

    @POST("registration/verification-code/send")
    suspend fun sendRegistrationVerificationCode(
        @Query("email") email: String,
    ): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse>

    @POST("registration/verification-code/verify")
    suspend fun verifyRegistrationCode(
        @Query("code") code: String,
        @Query("email") email: String?,
        @Query("phone_number") phoneNumber: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse>

    @POST("registration/create-profile")
    suspend fun createProfile(
        @Body request: CreateProfileRequest
    ): NetworkResponse<Unit, CreateProfileErrorResponse>

    @POST("posts")
    suspend fun getPosts(): NetworkResponse<List<Post>, Unit>
}