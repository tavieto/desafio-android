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
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    val android = Dependencies.Android
    val compose = Dependencies.Compose
    val external = Dependencies.External
    val features = Dependencies.Modules.Features
    val core = Dependencies.Modules.Core

    implementation(android.coreKtx)
    implementation(compose.coreUi)
    implementation(compose.uiPreview)
    implementation(compose.material)
    implementation(compose.activity)
    implementation(external.koin)
    implementation(external.koinAndroid)
    implementation(project(features.contact))
    implementation(project(core.core))
    implementation(project(core.design))
    implementation(project(core.navigation))

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
}