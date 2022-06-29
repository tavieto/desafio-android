plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("../android-common.gradle")

android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
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

    implementation(android.CORE_KTK)
    implementation(compose.CORE_UI)
    implementation(compose.UI_PREVIEW)
    implementation(compose.MATERIAL)
    implementation(compose.ACTIVITY)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
}
