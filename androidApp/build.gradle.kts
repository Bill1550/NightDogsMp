plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}
group = "com.loneoaktech.tests.nightdogsmp"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven("https://dl.bintray.com/kodein-framework/kodein-dev")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
}

android {
    compileSdkVersion(Versions.android_compile_sdk)
    defaultConfig {
        applicationId = "com.loneoaktech.tests.nightdogsmp.androidApp"
        minSdkVersion(Versions.android_min_sdk)
        targetSdkVersion(Versions.android_target_sdk)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}