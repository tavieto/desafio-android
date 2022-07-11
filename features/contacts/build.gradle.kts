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
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
}

dependencies {
    val android     = Dependencies.Android
    val compose     = Dependencies.Compose
    val core        = Dependencies.Modules.Core
    val domain      = Dependencies.Modules.Domain
    val external    = Dependencies.External
    val test        = Dependencies.Test
    val androidTest = Dependencies.AndroidTest

    implementation(android.coreKtx)
    implementation(compose.coreUi)
    implementation(compose.uiPreview)
    implementation(compose.material)
    implementation(compose.activity)
    implementation(external.koin)
    implementation(external.koinAndroid)
    implementation(external.koinCompose)
    implementation(project(core.core))
    implementation(project(core.design))
    implementation(project(domain.contact))
    testImplementation(test.archCoreTesting)
    testImplementation(test.mockK)
    testImplementation(test.jUnit)
    debugImplementation(androidTest.composeUiTestManifest)
    androidTestImplementation(androidTest.composeUiJUnit4)
    androidTestImplementation(androidTest.runner)
    androidTestImplementation(androidTest.testCoreKtx)
}
