plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("./../../android-common.gradle")

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
}

dependencies {
    val android = Dependencies.Android
    val compose = Dependencies.Compose

    api(android.coreKtx)
    api(compose.coreUi)
}