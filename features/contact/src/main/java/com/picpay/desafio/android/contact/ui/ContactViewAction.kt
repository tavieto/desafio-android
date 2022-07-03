package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.data.model.Contact

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
        data class Details(val contact: Contact) : ContactViewAction()
        object PopBackStack : ContactViewAction()
    }
    object Set {
        object Initialization : ContactViewAction()
    }
}
