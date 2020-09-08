package com.loneoaktech.tests.nightdogsmp.ui

import com.loneoaktech.tests.nightdogsmp.di.ServiceLocator
import com.loneoaktech.tests.nightdogsmp.domain.model.Location

suspend fun printSunRiseAndSet( serviceLocator: ServiceLocator ): String {

    return serviceLocator.astronomicalRepo.getSunTimes( Location(
        latitude = 41.0,
        longitude = -85.0
    ) ).let { rs ->
        "For ${rs.bodyName}: rise=${rs.riseTime.format("HH:mm:ss")}, set=${rs.setTime.format("HH:mm:ss")}"
    }

}