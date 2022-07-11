package com.picpay.desafio.android.contacts.ui

import com.picpay.desafio.android.contacts.data.model.Contact

data class ContacstViewState(
    val contacts: List<Contact> = emptyList(),
    val isInitialized: Boolean = false,
    val isLoading: Boolean = true,
    val unexpectedError: Throwable? = null
)
