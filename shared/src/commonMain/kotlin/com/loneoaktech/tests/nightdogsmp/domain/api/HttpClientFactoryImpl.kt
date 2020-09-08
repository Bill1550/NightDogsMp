package com.loneoaktech.tests.nightdogsmp.domain.api

import com.soywiz.klock.seconds
import io.ktor.client.*
import io.ktor.client.features.*

class HttpClientFactoryImpl : HttpClientFactory{

    override fun getClient(): HttpClient {
        return HttpClient {

            install(HttpTimeout) {
                requestTimeoutMillis = 15.seconds.millisecondsLong
                socketTimeoutMillis = 15.seconds.millisecondsLong
            }


        }
    }

}