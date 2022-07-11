package com.picpay.desafio.android.contacts.ui

import com.picpay.desafio.android.contacts.data.model.Contact

sealed class ContactsViewAction {
    object Clear {
        object Error {
            object Unexpected : ContactsViewAction()
        }
    }
    object Get {
        object Contacts : ContactsViewAction()
    }
    object Navigate {
        data class Details(val contact: Contact) : ContactsViewAction()
        object PopBackStack : ContactsViewAction()
    }
    object Set {
        object Initialization : ContactsViewAction()
    }
}
