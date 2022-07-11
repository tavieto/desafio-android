package com.picpay.desafio.android.contacts.di

import com.picpay.desafio.android.contacts.ui.ContactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureContactModel = module {
    viewModel { ContactsViewModel() }
}
