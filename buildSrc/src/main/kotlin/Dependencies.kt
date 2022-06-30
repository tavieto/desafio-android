object Dependencies {
    object Android {
        const val coreKtx                      = "androidx.core:core-ktx:${Versions.Android.coreKts}"
        const val viewModel                     = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
        const val lifecycleRuntime             = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
    }
    object Compose {
        const val activity                      = "androidx.activity:activity-compose:${Versions.Compose.activity}"
        const val coreUi                       = "androidx.compose.ui:ui:${Versions.Compose.coreUi}"
        const val material                      = "androidx.compose.material:material:${Versions.Compose.coreUi}"
        const val uiPreview                    = "androidx.compose.ui:ui-tooling:${Versions.Compose.coreUi}"
    }
    object External {
        const val coroutinesCore                = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.External.coroutines}"
        const val GLIDE                         = "com.github.skydoves:landscapist-glide:${Versions.External.glide}"
        const val koin                          =  "io.insert-koin:koin-core:${Versions.External.koin}"
        const val koinAndroid                   = "io.insert-koin:koin-android:${Versions.External.koin}"
        const val koinCompose                   = "io.insert-koin:koin-android:${Versions.External.koin}"
        object Test {
            const val koin                      = "io.insert-koin:koin-test:${Versions.External.koin}"
        }

    }
    object Modules {
        object Core {
            const val commons                   = ":core:commons"
            const val core                      = ":core:core"
            const val design                    = ":core:design"
            const val navigation                = ":core:navigation"
        }
        object Domain {
            const val contact                   = ":domain:contact"
        }
        object Features {
            const val contact                   = ":features:contact"
        }
    }
}
