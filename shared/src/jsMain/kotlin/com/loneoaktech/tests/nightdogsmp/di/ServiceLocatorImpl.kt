package com.loneoaktech.tests.nightdogsmp.di

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object ServiceLocatorImpl : ServiceLocatorCommon() {
    override val ioDispatcher: CoroutineContext
        get() = Dispatchers.Default

}