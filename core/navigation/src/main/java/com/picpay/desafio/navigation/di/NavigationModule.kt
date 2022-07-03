package com.picpay.desafio.navigation.di

import com.picpay.desafio.android.contact.ui.ContactNavigation
import com.picpay.desafio.navigation.core.NavManager
import com.picpay.desafio.navigation.navigation.ContactNavigationImpl
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
