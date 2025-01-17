// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("org.jacoco:org.jacoco.core:0.8.6")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module android-common.gradle files
    }
}

plugins {
    id("com.android.application").version("7.2.1").apply(false)
    id("com.android.library").version("7.2.1").apply(false)
    id("org.jetbrains.kotlin.android").version("1.5.31").apply(false)
    id("org.jetbrains.kotlin.jvm").version("1.6.10").apply(false)
}

allprojects {
    apply {
        plugin("jacoco")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
