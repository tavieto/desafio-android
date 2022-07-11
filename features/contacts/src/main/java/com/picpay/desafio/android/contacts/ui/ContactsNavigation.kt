package com.picpay.desafio.android.contacts.ui

import com.picpay.desafio.android.contacts.data.model.Contact

interface ContactsNavigation {
    fun test(contact: Contact)
    fun popBackStack()
}
