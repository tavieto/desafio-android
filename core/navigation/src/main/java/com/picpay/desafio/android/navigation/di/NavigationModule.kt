package com.picpay.desafio.android.navigation.di

import com.picpay.desafio.android.contact.ui.ContactNavigation
import com.picpay.desafio.android.navigation.core.NavManager
import com.picpay.desafio.android.navigation.navigation.ContactNavigationImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavManager(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
        )
    }

    single<ContactNavigation> { ContactNavigationImpl(get()) }
}