package com.loneoaktech.tests.nightdogsmp.di

import com.loneoaktech.tests.nightdogsmp.domain.api.HttpClientFactory
import com.loneoaktech.tests.nightdogsmp.domain.repos.AstronomicalRepo
import kotlin.coroutines.CoroutineContext

/**
 * A replacement for DI until Kodein is upgraded to Kotlin 1.4.0
 */
interface ServiceLocator {

    val ioDispatcher: CoroutineContext

    val httpClientFactory: HttpClientFactory

    val astronomicalRepo: AstronomicalRepo
}