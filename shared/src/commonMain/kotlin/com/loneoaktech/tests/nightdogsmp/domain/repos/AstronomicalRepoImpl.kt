package com.loneoaktech.tests.nightdogsmp.domain.repos

import com.loneoaktech.tests.nightdogsmp.di.ServiceLocator
import com.loneoaktech.tests.nightdogsmp.domain.model.Location
import com.loneoaktech.tests.nightdogsmp.domain.model.RiseAndSet
import com.soywiz.klock.DateTime
import com.soywiz.klock.hours
import kotlinx.coroutines.delay

class AstronomicalRepoImpl(
    private val serviceLocator: ServiceLocator
) : AstronomicalRepo {

    override suspend fun getSunTimes(location: Location): RiseAndSet {

        val sunTimesUrl="https://api.sunrise-sunset.org/json" // arguments: ?lat=41.4&lng=73.3

        delay( 500 )
        return RiseAndSet(
                bodyName = "sun",
                date = DateTime.now().date,
                riseTime = DateTime.now() - 6.hours,
                setTime = DateTime.now() + 6.hours
        )
    }

}