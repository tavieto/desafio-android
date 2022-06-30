package com.picpay.desafio.navigation.di

import com.picpay.desafio.android.contact.ui.ContactNavigation
import com.picpay.desafio.navigation.navigation.ContactNavigationImpl
import org.koin.dsl.module

val navigationModule = module {
    single<ContactNavigation> { ContactNavigationImpl() }
}
