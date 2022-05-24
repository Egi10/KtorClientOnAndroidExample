package com.buaja.ktorclientonandroidexample.di

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

@Module
class NetworkModule {
    @Single
    fun httpClient(): HttpClient = HttpClient(Android) {
        engine {
            connectTimeout = 1_000
            socketTimeout = 1_000
        }

        install(ContentNegotiation) {
            json()
        }

        install(Logging) {
            level = LogLevel.BODY
        }
    }
}