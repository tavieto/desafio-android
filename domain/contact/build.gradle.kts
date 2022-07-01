plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val core        = Dependencies.Modules.Core
    val external    = Dependencies.External

    implementation(external.koin)
    implementation(project(core.commons))
}