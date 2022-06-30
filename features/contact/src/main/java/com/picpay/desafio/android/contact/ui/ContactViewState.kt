package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.model.User

data class ContactViewState(
    val contacts: List<User> = emptyList(),
    val isLoading: Boolean = true
)
