package com.picpay.desafio.android.network.di

import com.picpay.desafio.android.network.core.NetworkBases
import com.picpay.desafio.android.network.core.NetworkWrapper
import com.picpay.desafio.android.network.core.Retrofit
import com.picpay.desafio.android.network.datasource.ContactsRemoteDataSourceImpl
import com.picpay.desafio.android.network.service.PicPayService
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import org.koin.dsl.module

val networkModule = module {
    single { NetworkWrapper() }

    single<PicPayService> {
        Retrofit(baseUrl = NetworkBases.PIC_PAY)
    }

    single<ContactsRemoteDataSource> {
        ContactsRemoteDataSourceImpl(get())
    }
}
