package com.ruslankalbaev.ourawesomeapp.di.module

import com.daniillyubaev.ourawesomeapp.data.json.AuthTokensAdapter
import com.daniillyubaev.ourawesomeapp.entity.AuthTokens
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SerializationModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(AuthTokens::class.java, AuthTokensAdapter().nullSafe())
            .build()
}