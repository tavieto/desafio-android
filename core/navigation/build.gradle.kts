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
    val android     = Dependencies.Android
    val compose     = Dependencies.Compose
    val external    = Dependencies.External
    val feature     = Dependencies.Modules.Features

    implementation(android.coreKtx)
    implementation(compose.navigation)
    implementation(compose.navigationAnimation)
    implementation(compose.navigationCommon)
    implementation(external.koin)
    implementation(project(feature.contact))
}
