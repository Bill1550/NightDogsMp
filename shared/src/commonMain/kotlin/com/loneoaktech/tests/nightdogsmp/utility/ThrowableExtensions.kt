package com.loneoaktech.tests.nightdogsmp.utility


/**
 * Creates a short summary suitable for logging when showing the whole stack trace
 * isn't needed.
 */
fun Throwable.summary(): String =
        "class=${this::class.simpleName}, msg='${this.message}'"