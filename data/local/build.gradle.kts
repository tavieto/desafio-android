plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("./../../android-common.gradle")

android {
    defaultConfig {
        minSdk = 21
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
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation(androidTest.jUnit)
}