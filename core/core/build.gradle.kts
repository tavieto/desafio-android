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
    val core        = Dependencies.Modules.Core
    val external    = Dependencies.External
    val test        = Dependencies.Test

    api(android.coreKtx)
    api(android.viewModel)
    api(compose.coreUi)
    api(external.koin)
    api(project(core.commons))
    implementation(test.jUnit)
}
