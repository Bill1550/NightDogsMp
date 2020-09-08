package com.loneoaktech.tests.nightdogsmp.domain.api

import io.ktor.client.*

/**
 * Construct ktor http client.
 */
interface HttpClientFactory {
    fun getClient(): HttpClient
}