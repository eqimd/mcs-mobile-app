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

class MockApi : Api {
    override suspend fun getUsers(): NetworkResponse<List<User>, Unit> {
        return NetworkResponse.Success(
            body = listOf(
                User(
                    id = 0,
                    username = "c00l_k1tty",
                    avatarUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/9e/9e486624eac2dc00d96667516c8ad18e5d5a90d6_full.jpg",
                    firstName = "Ki",
                    lastName = "Tty",
                    groupName = "testkitty"
                )
            ),
            code = 200
        )
    }

    override suspend fun signInWithEmail(request: SignInWithEmailRequest): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }

    override suspend fun refreshAuthTokens(request: RefreshAuthTokensRequest): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun sendRegistrationVerificationCode(email: String): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        return NetworkResponse.Success(
            Unit,
            code = 200
        )
    }

    override suspend fun verifyRegistrationCode(
        code: String,
        email: String?,
        phoneNumber: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        return NetworkResponse.Success(
            VerificationTokenResponse("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI"),
            code = 200
        )
    }

    override suspend fun createProfile(request: CreateProfileRequest): NetworkResponse<Unit, CreateProfileErrorResponse> {
        return NetworkResponse.Success(
            Unit,
            code = 200
        )
    }

    override suspend fun getPosts(): NetworkResponse<List<Post>, Unit> {
        TODO("Not yet implemented")
    }
}