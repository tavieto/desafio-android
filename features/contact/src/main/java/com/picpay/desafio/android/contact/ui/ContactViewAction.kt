package com.picpay.desafio.android.contact.ui

sealed class ContactViewAction {
    object Clear {
        object Error {
            object Unexpected : ContactViewAction()
        }
    }
    object Get {
        object Contacts : ContactViewAction()
    }
    object Navigate {
        object Details : ContactViewAction()
    }
    object Set {
        object Initialization : ContactViewAction()
    }
}
