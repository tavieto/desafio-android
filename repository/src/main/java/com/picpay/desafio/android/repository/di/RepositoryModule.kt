package com.picpay.desafio.android.repository.di

import com.picpay.desafio.android.contact.repository.ContactsRepository
import com.picpay.desafio.android.repository.repository.ContactsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ContactsRepository> { ContactsRepositoryImpl(get(), get()) }
}
