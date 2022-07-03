package com.picpay.desafio.android.contact.factory

import com.picpay.desafio.android.contact.data.model.ContactDomain

object GetContactsFactory {
    val LIST_CONTACTS: List<ContactDomain> = listOf(
        ContactDomain(
            id = "0",
            name = "Otávio",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "tavieto"
        )
    )
}
