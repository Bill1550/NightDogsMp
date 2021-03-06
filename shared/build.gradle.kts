import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.kotlin
    id("com.android.library")
    id("kotlin-android-extensions")
}
group = "com.loneoaktech.tests.tempapp"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
//    maven("https://dl.bintray.com/kodein-framework/kodein-dev")
    google()
    jcenter()
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    js {
        browser {

        }
//        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api( Deps.kotlinx_coroutines )
                api( Deps.kotlinx_serialization )

                implementation( Deps.ktor_client )
                implementation( Deps.ktor_client_serialization )
                implementation( Deps.ktor_client_json )
                implementation( Deps.ktor_client_logging )

                api( Deps.klock )
                api( Deps.klogger )
            }
        }


        val commonTest by getting {
            dependencies {
                implementation( Deps.kotlinx_coroutines )
                implementation( Deps.kotlinx_serialization )
                implementation( Deps.klock )

                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.1")
            }
        }
        val iosMain by getting
        val iosTest by getting

        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.0")
                implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.0")
                implementation(npm("react", "16.13.1"))
                implementation(npm("react-dom", "16.13.1"))
            }
        }

        val jsTest by getting
    }
}

android {
    compileSdkVersion(Versions.android_compile_sdk)
    sourceSets["main"].manifest.srcFile("src\\androidMain\\AndroidManifest.xml")
    defaultConfig {
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

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)