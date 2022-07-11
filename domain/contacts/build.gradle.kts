plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val core        = Dependencies.Modules.Core
    val external    = Dependencies.External
    val test        = Dependencies.Test

    implementation(external.koin)
    implementation(project(core.commons))
    testImplementation(test.mockK)
    testImplementation(test.jUnit)
}