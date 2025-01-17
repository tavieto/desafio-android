object Dependencies {
    object Android {
        const val coreKtx               = "androidx.core:core-ktx:${Versions.Android.coreKts}"
        const val roomCompiler          = "androidx.room:room-compiler:${Versions.Android.room}"
        const val roomKtx               = "androidx.room:room-ktx:${Versions.Android.room}"
        const val roomRuntime           = "androidx.room:room-runtime:${Versions.Android.room}"
        const val viewModel             = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Android.viewModel}"
    }
    object Compose {
        const val activity              = "androidx.activity:activity-compose:${Versions.Compose.activity}"
        const val coreUi                = "androidx.compose.ui:ui:${Versions.Compose.coreUi}"
        const val material              = "androidx.compose.material:material:${Versions.Compose.coreUi}"
        const val navigation            = "androidx.navigation:navigation-compose:${Versions.Compose.navigation}"
        const val navigationAnimation   = "com.google.accompanist:accompanist-navigation-animation:${Versions.Compose.navigationAnimation}"
        const val navigationCommon      = "androidx.navigation:navigation-common-ktx:${Versions.Compose.navigation}"
        const val uiPreview             = "androidx.compose.ui:ui-tooling:${Versions.Compose.coreUi}"
    }
    object External {
        const val coroutinesCore        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.External.coroutines}"
        const val glide                 = "com.github.skydoves:landscapist-glide:${Versions.External.glide}"
        const val gson                  = "com.squareup.retrofit2:converter-gson:${Versions.External.retrofit}"
        const val koin                  = "io.insert-koin:koin-core:${Versions.External.koin}"
        const val koinAndroid           = "io.insert-koin:koin-android:${Versions.External.koin}"
        const val koinCompose           = "io.insert-koin:koin-androidx-compose:${Versions.External.koin}"
        const val memoryLeak            = "com.squareup.leakcanary:leakcanary-android:${Versions.External.memoryLeak}"
        const val okHttp                = "com.squareup.okhttp3:okhttp:${Versions.External.okHttp}"
        const val okHttpLogging         = "com.squareup.okhttp3:logging-interceptor:${Versions.External.okHttp}"
        const val retrofit              = "com.squareup.retrofit2:retrofit:${Versions.External.retrofit}"

    }
    object Modules {
        const val repository            = ":repository"
        object Core {
            const val commons           = ":core:commons"
            const val core              = ":core:core"
            const val design            = ":core:design"
            const val navigation        = ":core:navigation"
        }
        object Data {
            const val network           = ":data:network"
            const val local             = ":data:local"
        }
        object Domain {
            const val contact           = ":domain:contacts"
        }
        object Features {
            const val contact           = ":features:contacts"
        }
    }
    object Test {
        const val archCoreTesting       = "androidx.arch.core:core-testing:${Versions.Test.coreTest}"
        const val jUnit                 = "junit:junit:${Versions.Test.jUnit}"
        const val koin                  = "io.insert-koin:koin-test:${Versions.External.koin}"
        const val mockK                 = "io.mockk:mockk:${Versions.Test.mockK}"
        const val room                  = "androidx.room:room-testing:${Versions.Android.room}"
    }
    object AndroidTest {
        const val composeUiJUnit4       = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.coreUi}"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.coreUi}"
        const val jUnit                 = "androidx.test.ext:junit-ktx:${Versions.AndroidTest.jUnit}"
        const val rules                 = "androidx.test:rules:${Versions.AndroidTest.rules}"
        const val runner                = "androidx.test:runner:${Versions.AndroidTest.runner}"
        const val testCoreKtx           = "androidx.test:core-ktx:${Versions.AndroidTest.coreTestKtx}"
    }
}
