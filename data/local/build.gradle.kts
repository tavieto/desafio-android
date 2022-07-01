plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("./../../android-common.gradle")

dependencies {
    val roomVersion = "2.4.2"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    val android     = Dependencies.Android
    val external    = Dependencies.External
    val modules     = Dependencies.Modules

    implementation(android.coreKtx)
    implementation(external.koin)
    implementation(external.koinAndroid)
    implementation(project(modules.repository))

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$roomVersion")


}