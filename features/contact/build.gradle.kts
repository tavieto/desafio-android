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
    val domain      = Dependencies.Modules.Domain
    val external    = Dependencies.External
    val test        = Dependencies.Test

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

    testImplementation(test.mockK)
    testImplementation(test.jUnit)
    testImplementation(test.coreTest)
    testImplementation(test.coroutinesTest)
    testImplementation(test.coroutinesAndroid)

    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
}
