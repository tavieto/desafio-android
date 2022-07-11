plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

    api(android.coreKtx)
    api(compose.coreUi)
    api(compose.uiPreview)
    api(compose.material)
    api(compose.activity)
    api(external.glide)
}