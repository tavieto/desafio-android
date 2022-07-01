plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val external = Dependencies.External

    api(external.coroutinesCore)
}