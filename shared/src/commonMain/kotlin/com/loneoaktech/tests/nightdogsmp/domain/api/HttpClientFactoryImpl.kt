package com.loneoaktech.tests.nightdogsmp.domain.api

import com.soywiz.klock.seconds
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*

class HttpClientFactoryImpl : HttpClientFactory{

    override fun getClient(): HttpClient {
        return HttpClient {

            install(HttpTimeout) {
                requestTimeoutMillis = 15.seconds.millisecondsLong
                socketTimeoutMillis = 15.seconds.millisecondsLong
            }

            install(Logging) {
                logger = object: Logger {
                    override fun log(message: String) {
                        com.soywiz.klogger.Logger<HttpClient>().info { message }
                    }
                }

                level = LogLevel.HEADERS
            }


        }
    }

}