package com.picpay.desafio.android.contacts.ui

import com.picpay.desafio.android.contacts.data.model.Contact
import com.picpay.desafio.android.contacts.ui.ContacstViewState

object ContactsFactory {
    val VIEW_STATE_LIST = ContacstViewState(
        isLoading = false,
        unexpectedError = null,
        contacts = listOf(
            Contact(
                id = "0",
                name = "Otávio",
                image = "https://avatars.githubusercontent.com/u/56049250?v=4",
                username = "tavieto"
            ),
            Contact(
                id = "1",
                name = "Gabriel",
                image = "https://avatars.githubusercontent.com/u/56049250?v=4",
                username = "tavieto1"
            )
        )
    )
    val VIEW_STATE_LOADING = ContacstViewState(
        isLoading = true,
        unexpectedError = null,
        contacts = listOf()
    )
    val VIEW_STATE_ERROR = ContacstViewState(
        isLoading = false,
        unexpectedError = Throwable(),
        contacts = listOf()
    )
}
