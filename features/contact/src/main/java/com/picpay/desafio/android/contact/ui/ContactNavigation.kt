package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.data.model.Contact

interface ContactNavigation {
    fun test(contact: Contact)
    fun popBackStack()
}
