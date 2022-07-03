package com.picpay.desafio.android.network.factory

import com.picpay.desafio.android.network.data.model.ContactResponse

object NetworkWrapperFactory {
    val LIST_CONTACTS_RESPONSE = listOf(
        ContactResponse(
            id = "0",
            name = "Otávio",
            image = "https://avatars.githubusercontent.com/u/56049250?v=4",
            username = "tavieto"
        )
    )
}
