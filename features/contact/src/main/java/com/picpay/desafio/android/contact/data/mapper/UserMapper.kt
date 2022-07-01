package com.picpay.desafio.android.contact.data.mapper

import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.contact.data.model.ContactDomain

fun ContactDomain.fromDomain() = Contact(
    id = this.id,
    name = this.name,
    image = this.image,
    username = this.username
)
