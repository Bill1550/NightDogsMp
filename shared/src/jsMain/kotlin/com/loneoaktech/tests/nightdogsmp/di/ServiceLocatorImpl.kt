package com.loneoaktech.tests.nightdogsmp.di

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ServiceLocatorImpl : ServiceLocator {
    override val ioDispatcher: CoroutineContext
        get() = Dispatchers.Default

}