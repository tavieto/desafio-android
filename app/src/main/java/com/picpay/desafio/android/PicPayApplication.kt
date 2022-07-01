package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.contact.di.domainContactModule
import com.picpay.desafio.android.contact.di.featureContactModel
import com.picpay.desafio.android.local.di.localModule
import com.picpay.desafio.android.network.di.networkModule
import com.picpay.desafio.android.repository.di.repositoryModule
import com.picpay.desafio.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PicPayApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                domainContactModule,
                featureContactModel,
                localModule,
                navigationModule,
                networkModule,
                repositoryModule
            ).androidContext(this@PicPayApplication)
        }
    }
}
