plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val modules         = Dependencies.Modules
    val external        = Dependencies.External

    implementation(external.gson)
    implementation(external.koin)
    implementation(external.okHttp)
    implementation(external.retrofit)
    implementation(external.okHttpLogging)
    implementation(project(modules.repository))
}
