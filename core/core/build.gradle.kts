plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("./../../android-common.gradle")

android {
    defaultConfig {
        minSdk = AppConfig.minSdk
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
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
    val test        = Dependencies.Test
    val androidTest = Dependencies.AndroidTest

    api(android.coreKtx)
    api(android.viewModel)
    api(compose.coreUi)
    api(external.koin)
    api(project(core.commons))
    implementation(test.jUnit)
    debugImplementation(androidTest.composeUiTestManifest)
    androidTestImplementation(androidTest.composeUiJUnit4)
    androidTestImplementation(androidTest.runner)
    androidTestImplementation(androidTest.testCoreKtx)
}
