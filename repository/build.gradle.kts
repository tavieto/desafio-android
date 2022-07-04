plugins {
    id("kotlin")
}

dependencies {
    val core        = Dependencies.Modules.Core
    val domain      = Dependencies.Modules.Domain
    val external    = Dependencies.External
    val test        = Dependencies.Test

    api(project(domain.contact))
    api(project(core.commons))
    implementation(external.koin)
    testImplementation(test.jUnit)
    testImplementation(test.mockK)
}
