package com.picpay.desafio.android.network.factory

import com.picpay.desafio.android.network.data.mapper.toDomain
import com.picpay.desafio.android.network.data.model.ContactResponse

object ContactsFactory {
    val LIST_CONTACTS_RESPONSE = listOf(
        ContactResponse(
            id = "0",
            name = "Otávio",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "tavieto"
        )
    )
    val LIST_CONTACTS_DOMAIN = LIST_CONTACTS_RESPONSE.map { it.toDomain() }
}
