object Dependencies {
    object Android {
        const val coreKtx                      = "androidx.core:core-ktx:${Versions.Android.CORE_KTX}"
        const val LIFECYCLE_RUNTIME             = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }
    object Compose {
        const val activity                      = "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY}"
        const val coreUi                       = "androidx.compose.ui:ui:${Versions.Compose.CORE_UI}"
        const val material                      = "androidx.compose.material:material:${Versions.Compose.CORE_UI}"
        const val uiPreview                    = "androidx.compose.ui:ui-tooling:${Versions.Compose.CORE_UI}"
    }
    object External {
        const val GLIDE                         = "com.github.skydoves:landscapist-glide:${Versions.External.GLIDE}"
        const val koin                          =  "io.insert-koin:koin-core:${Versions.External.koin}"
        const val koinAndroid                   = "io.insert-koin:koin-android:${Versions.External.koin}"
        const val koinCompose                   = "io.insert-koin:koin-android:${Versions.External.koin}"
        object Test {
            const val koin                      = "io.insert-koin:koin-test:${Versions.External.koin}"
        }

    }
    object Modules {

        object Core {
            const val design                    = ":core:design"
            const val core                      = ":core:core"
            const val navigation                = ":core:navigation"
        }
        object Features {
            const val contacts                  = ":features:contacts"
        }
    }
}
