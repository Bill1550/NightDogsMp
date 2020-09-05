package com.loneoaktech.tests.nightdogsmp.shared



class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
