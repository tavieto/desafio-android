plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("./../../android-common.gradle")

dependencies {
    val android = Dependencies.Android
    val external = Dependencies.External
    val feature = Dependencies.Modules.Features

    implementation(android.coreKtx)
    implementation(external.koin)
    implementation(project(feature.contact))
}
