package com.picpay.desafio.android.repository.factory

import com.picpay.desafio.android.contacts.data.model.ContactDomain

object ContactsFactory {
    val LIST_CONTACTS = listOf(
        ContactDomain(
            id = "0",
            name = "Otávio",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "tavieto"
        )
    )

    val LIST_CONTACTS_LOCAL = listOf(
        ContactDomain(
            id = "0",
            name = "Jorge",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "jorge"
        )
    )
}
