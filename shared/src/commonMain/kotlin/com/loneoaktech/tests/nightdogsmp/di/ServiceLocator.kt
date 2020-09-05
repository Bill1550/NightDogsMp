package com.loneoaktech.tests.nightdogsmp.di

import kotlin.coroutines.CoroutineContext

/**
 * A replacement for DI until Kodein is upgraded to Kotlin 1.4.0
 */
interface ServiceLocator {

    val ioDispatcher: CoroutineContext
}