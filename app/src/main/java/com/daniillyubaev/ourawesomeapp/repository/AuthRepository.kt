package com.daniillyubaev.ourawesomeapp.repository

import com.daniillyubaev.ourawesomeapp.data.network.Api
import com.daniillyubaev.ourawesomeapp.data.network.request.CreateProfileRequest
import com.daniillyubaev.ourawesomeapp.data.network.request.RefreshAuthTokensRequest
import com.daniillyubaev.ourawesomeapp.data.network.request.SignInWithEmailRequest
import com.daniillyubaev.ourawesomeapp.data.network.response.VerificationTokenResponse
import com.daniillyubaev.ourawesomeapp.data.network.response.error.*
import com.daniillyubaev.ourawesomeapp.data.persistent.LocalKeyValueStorage
import com.daniillyubaev.ourawesomeapp.di.module.AppCoroutineScope
import com.daniillyubaev.ourawesomeapp.di.module.IoCoroutineDispatcher
import com.daniillyubaev.ourawesomeapp.entity.AuthTokens
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject
import dagger.Lazy
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiLazy: Lazy<Api>,
    private val localKeyValueStorage: LocalKeyValueStorage,
    @AppCoroutineScope externalCoroutineScope: CoroutineScope,
    @IoCoroutineDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    private val api by lazy { apiLazy.get() }

    private val authTokensFlow: Deferred<MutableStateFlow<AuthTokens?>> =
        externalCoroutineScope.async(context = ioDispatcher, start = CoroutineStart.LAZY) {
            Timber.d("Initializing auth tokens flow.")
            MutableStateFlow(
                localKeyValueStorage.authTokens
            )
        }

    suspend fun getAuthTokensFlow(): StateFlow<AuthTokens?> {
        return authTokensFlow.await().asStateFlow()
    }

    /**
     * @param authTokens active auth tokens which must be used for signing all requests
     */
    suspend fun saveAuthTokens(authTokens: AuthTokens?) {
        withContext(ioDispatcher) {
            Timber.d("Persist auth tokens $authTokens.")
            localKeyValueStorage.authTokens = authTokens
        }
        Timber.d("Emit auth tokens $authTokens.")
        authTokensFlow.await().emit(authTokens)
    }

    /**
     * @return whether active access tokens are authorized or not
     */
    suspend fun isAuthorizedFlow(): Flow<Boolean> {
        return authTokensFlow
            .await()
            .asStateFlow()
            .map { it != null }
    }

    suspend fun generateAuthTokensByEmail(
        email: String,
        password: String
    ): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return api.signInWithEmail(SignInWithEmailRequest(email, password))
    }

    /**
     * Creates a user account in the system as a side effect.
     * @return access tokens with higher permissions for the new registered user
     */
    suspend fun generateAuthTokensByEmailAndPersonalInfo(
        email: String,
        verificationToken: String,
        firstName: String,
        lastName: String,
        password: String
    ): NetworkResponse<Unit, CreateProfileErrorResponse> {
        return api.createProfile(
            CreateProfileRequest(
                verificationToken,
                firstName,
                lastName,
                email,
                password
            )
        )
    }

    suspend fun generateRefreshedAuthTokens(refreshToken: String): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        return api.refreshAuthTokens(RefreshAuthTokensRequest(refreshToken))
    }

    suspend fun sendRegistrationVerificationCodeRequest(
        email: String,
    ): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        return api.sendRegistrationVerificationCode(email)
    }

    suspend fun createProfile(
        username: String,
        firstname: String,
        lastname: String,
        email: String,
        password: String
    ): NetworkResponse<Unit, CreateProfileErrorResponse> {
        return api.createProfile(
            CreateProfileRequest(
                username = username,
                firstname = firstname,
                lastname = lastname,
                email = email,
                password = password
            )
        )
    }

    suspend fun verifyRegistrationCode(
        code: String,
        email: String,
        phoneNumber: String
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        return api.verifyRegistrationCode(code, email, phoneNumber)
    }
}