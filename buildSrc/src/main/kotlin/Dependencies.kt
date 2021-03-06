
object Versions {

    const val android_min_sdk = 21
    const val android_target_sdk = 30
    const val android_compile_sdk = 30
    const val android_gradle_plugin = "4.1.0"

    const val klock = "1.12.0"
    const val klogger = "1.11.0"

    const val kodein = "7.1.0-master-80" // From Bintray, dev version that supports 1.4.0

    const val kotlin = "1.4.20"
    const val kotlinx_coroutines = "1.4.1"
    const val kotlinx_datetime = "0.1.0"
    const val kotlinx_serialization = "1.0.1"
    const val kotlinx_html = "0.7.2"
    const val kotlinx_atomic_fu = "0.14.4"

    const val ktor = "1.4.1"
}


object Deps {
    const val klock = "com.soywiz.korlibs.klock:klock:${Versions.klock}"

    const val klogger = "com.soywiz.korlibs.klogger:klogger:${Versions.klogger}"

    const val kodein = "org.kodein.di:kodein-di:${Versions.kodein}"

    const val kotlinx_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines}"
    const val kotlinx_datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinx_datetime}"
    const val kotlinx_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinx_serialization}"

    const val ktor_client = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktor_client_json = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val ktor_client_logging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val ktor_client_serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"


}
