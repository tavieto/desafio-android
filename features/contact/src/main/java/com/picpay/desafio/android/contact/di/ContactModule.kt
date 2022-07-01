package com.picpay.desafio.android.contact.di

import com.picpay.desafio.android.contact.ui.ContactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureContactModel = module {
    viewModel { ContactViewModel() }
}
