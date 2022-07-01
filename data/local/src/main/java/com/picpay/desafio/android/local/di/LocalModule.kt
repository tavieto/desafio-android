package com.picpay.desafio.android.local.di

import androidx.room.Room
import com.picpay.desafio.android.local.database.ContactsDatabase
import com.picpay.desafio.android.local.datasource.ContactsLocalDataSourceImpl
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            ContactsDatabase::class.java,
            "contacts_database"
        ).build()
    }

    single {
        get<ContactsDatabase>().contactsDao()
    }

    single<ContactsLocalDataSource> {
        ContactsLocalDataSourceImpl(get())
    }
}
