package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.data.model.Contact

data class ContactViewState(
    val contacts: List<Contact> = emptyList(),
    val isInitialized: Boolean = false,
    val isLoading: Boolean = true,
    val unexpectedError: Throwable? = null
)
