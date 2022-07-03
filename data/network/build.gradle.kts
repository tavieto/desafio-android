plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val modules     = Dependencies.Modules
    val external    = Dependencies.External
    val test        = Dependencies.Test

    implementation(external.gson)
    implementation(external.koin)
    implementation(external.okHttp)
    implementation(external.retrofit)
    implementation(external.okHttpLogging)
    implementation(project(modules.repository))
    testImplementation(test.mockK)
    testImplementation(test.jUnit)
}
