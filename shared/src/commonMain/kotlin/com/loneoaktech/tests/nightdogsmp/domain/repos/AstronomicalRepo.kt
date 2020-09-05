package com.loneoaktech.tests.nightdogsmp.domain.repos

import com.loneoaktech.tests.nightdogsmp.domain.model.Location
import com.loneoaktech.tests.nightdogsmp.domain.model.RiseAndSet

interface AstronomicalRepo {

    suspend fun getSunTimes( location: Location): RiseAndSet
}