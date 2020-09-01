buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        // The wizzard apparently adds this class path to permit legacy apply in the subproject gradle
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:4.1.0-rc02")
    }
}
group = "com.loneoaktech.tests.nightdogsmp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
