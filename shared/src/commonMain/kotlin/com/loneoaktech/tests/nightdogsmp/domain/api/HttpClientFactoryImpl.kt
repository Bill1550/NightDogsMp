package com.loneoaktech.tests.nightdogsmp.domain.api

import com.soywiz.klock.seconds
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.json.JsonFeature
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class HttpClientFactoryImpl : HttpClientFactory{

    override fun getClient(): HttpClient {
        return HttpClient {

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    json = Json {
                                encodeDefaults = false
                                ignoreUnknownKeys = true
                                isLenient = true
                            }
                )

            }


            install(HttpTimeout) {
                requestTimeoutMillis = 15.seconds.millisecondsLong
                socketTimeoutMillis = 15.seconds.millisecondsLong
            }

            install(UserAgent) {
                agent = "NIGHT-DOGS-MP"
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