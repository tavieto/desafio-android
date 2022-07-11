plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

apply("./../../android-common.gradle")

android {
    defaultConfig {
        minSdk = AppConfig.minSdk
    }
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
    val core        = Dependencies.Modules.Core
    val external    = Dependencies.External
    val feature     = Dependencies.Modules.Features

    implementation(android.coreKtx)
    implementation(compose.navigation)
    implementation(compose.navigationAnimation)
    implementation(compose.navigationCommon)
    implementation(external.gson)
    implementation(external.koin)
    implementation(external.koinCompose)
    implementation(project(feature.contact))
    implementation(project(core.core))
}
