package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.contact.data.model.ContactDomain

object ContactFactory {
    val LIST_CONTACTS_DOMAIN: List<ContactDomain> = listOf(
        ContactDomain(
            id = "0",
            name = "Otávio",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "tavieto"
        )
    )
    val CONTACT = Contact(
        id = "0",
        name = "Otávio",
        image = "https://avatars.githubusercontent.com/u/56049250?v=4",
        username = "tavieto"
    )
}
