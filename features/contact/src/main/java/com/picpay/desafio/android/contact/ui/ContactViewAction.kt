package com.picpay.desafio.android.contact.ui

sealed class ContactViewAction {
    object Get {
        object Contacts : ContactViewAction()
    }
    object Navigate {
        object Details : ContactViewAction()
    }
}
