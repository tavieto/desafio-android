package com.picpay.desafio.android.contact.di

import com.picpay.desafio.android.contact.usecase.GetContactsUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainContactModule = module {
    factory { (scope: CoroutineScope) ->
        GetContactsUseCase(scope, get())
    }
}
