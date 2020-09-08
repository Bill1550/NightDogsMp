package com.loneoaktech.tests.nightdogsmp.shared

import com.soywiz.klogger.Logger


class Greeting {
    fun greeting(): String {
        Logger<Greeting>().info { "Getting greeting" }
        return "Hello, ${Platform().platform}!"
    }
}
