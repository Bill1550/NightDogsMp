
plugins {
    kotlin("js")
}

group = "com.loneoaktech"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}


dependencies {
    implementation(kotlin("stdlib-js"))
    implementation( project( ":shared" ) )

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.0")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))


}

kotlin {

    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }

//            dceTask {
//                dceOptions {
//                    outputDirectory = "$projectDir\\build\\js\\packages\\kotlin-dce-dev"  //"$buildDir/js/packages/${project.name}/kotlin-dce-dev"
//                }
//            }

        }

        binaries.executable()
    }

}
