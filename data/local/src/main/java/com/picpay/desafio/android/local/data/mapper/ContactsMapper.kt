package com.picpay.desafio.android.local.data.mapper

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.local.data.model.ContactsEntity

fun ContactsEntity.toDomain() = ContactDomain(
    id = id,
    name = name,
    image = image,
    username = username
)
