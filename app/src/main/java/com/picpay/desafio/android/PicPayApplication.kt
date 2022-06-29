package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PicPayApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                navigationModule
            ).androidContext(this@PicPayApplication)
        }
    }
}
