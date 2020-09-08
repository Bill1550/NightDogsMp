package com.loneoaktech.tests.nightdogsmp.di

import com.loneoaktech.tests.nightdogsmp.domain.api.HttpClientFactory
import com.loneoaktech.tests.nightdogsmp.domain.api.HttpClientFactoryImpl
import com.loneoaktech.tests.nightdogsmp.domain.repos.AstronomicalRepo
import com.loneoaktech.tests.nightdogsmp.domain.repos.AstronomicalRepoImpl

/**
 * Common module base implementation of service locator.  Returns
 * those items that are implemented in common code.
 */
abstract class ServiceLocatorCommon : ServiceLocator {


    override val httpClientFactory: HttpClientFactory by lazy { HttpClientFactoryImpl() }

    override val astronomicalRepo: AstronomicalRepo by lazy { AstronomicalRepoImpl(this) }
}