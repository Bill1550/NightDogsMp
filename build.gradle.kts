plugins {
    id("org.jetbrains.kotlin.js") version "1.4.0" apply false
//    kotlin("js") apply false
}

buildscript {
    repositories {
        maven("https://kotlin.bintray.com/kotlin-js-wrappers/")

        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }

    dependencies {
        // The wizard apparently adds this class path to permit legacy apply in the subproject gradle
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.android_gradle_plugin}")
    }
}
group = "com.loneoaktech.tests.nightdogsmp"
version = "1.0-SNAPSHOT"

//subprojects {
//    if (name.startsWith("js"))
//        apply(plugin = "org.jetbrains.kotlin.js")
//}

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}
