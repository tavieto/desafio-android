plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("./../../android-common.gradle")

android {
    defaultConfig {
        minSdk = AppConfig.minSdk
    }
    defaultConfig {
        minSdk = 21
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    val android     = Dependencies.Android
    val external    = Dependencies.External
    val modules     = Dependencies.Modules
    val test        = Dependencies.Test
    val androidTest = Dependencies.AndroidTest

    implementation(android.coreKtx)
    implementation(android.roomRuntime)
    implementation(external.koin)
    implementation(external.koinAndroid)
    implementation(project(modules.repository))
    kapt(android.roomCompiler)
    androidTestImplementation(test.jUnit)

    // optional - Test helpers
    testImplementation(test.room)
    androidTestImplementation(androidTest.rules)
    androidTestImplementation(androidTest.runner)
    androidTestImplementation(androidTest.jUnit)
}