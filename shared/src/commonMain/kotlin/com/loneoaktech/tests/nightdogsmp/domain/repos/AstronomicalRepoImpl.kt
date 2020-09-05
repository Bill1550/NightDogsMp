package com.loneoaktech.tests.nightdogsmp.domain.repos

import com.loneoaktech.tests.nightdogsmp.di.ServiceLocator
import com.loneoaktech.tests.nightdogsmp.domain.model.Location
import com.loneoaktech.tests.nightdogsmp.domain.model.RiseAndSet

class AstronomicalRepoImpl(
    private val serviceLocator: ServiceLocator
) : AstronomicalRepo {

    override suspend fun getSunTimes(location: Location): RiseAndSet {
        TODO("Not yet implemented")
    }

}