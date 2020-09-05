package com.loneoaktech.tests.nightdogsmp.domain.model

import com.soywiz.klock.Date
import com.soywiz.klock.DateTime

data class RiseAndSet(
    val bodyName: String,
    val date: Date,
    val riseTime: DateTime,
    val setTime: DateTime
)