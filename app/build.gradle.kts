plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("../android-common.gradle")

android {

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
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
    val data        = Dependencies.Modules.Data
    val domain      = Dependencies.Modules.Domain
    val external    = Dependencies.External
    val features    = Dependencies.Modules.Features
    val modules     = Dependencies.Modules

    implementation(compose.activity)
    implementation(android.coreKtx)
    implementation(compose.coreUi)
    implementation(compose.material)
    implementation(compose.navigation)
    implementation(compose.uiPreview)
    implementation(external.koin)
    implementation(external.koinAndroid)
    implementation(external.koinCompose)
    implementation(project(core.core))
    implementation(project(core.design))
    implementation(project(core.navigation))
    implementation(project(data.local))
    implementation(project(data.network))
    implementation(project(domain.contact))
    implementation(project(features.contact))
    implementation(project(modules.repository))
    debugImplementation(external.memoryLeak)
}
