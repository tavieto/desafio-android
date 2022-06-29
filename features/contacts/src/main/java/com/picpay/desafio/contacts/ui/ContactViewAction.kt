package com.picpay.desafio.contacts.ui

sealed class ContactViewAction {
    object Get {
        object Contacts : ContactViewAction()
    }
    object Navigate {
        object Details : ContactViewAction()
    }
}
