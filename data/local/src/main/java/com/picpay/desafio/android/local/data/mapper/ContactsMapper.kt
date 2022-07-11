package com.picpay.desafio.android.local.data.mapper

import com.picpay.desafio.android.contacts.data.model.ContactDomain
import com.picpay.desafio.android.local.data.model.ContactEntity

fun ContactEntity.toDomain() = ContactDomain(
    id = this.id,
    name = this.name,
    image = this.image,
    username = this.username
)

fun ContactDomain.fromDomain() = ContactEntity(
    id = this.id,
    name = this.name,
    image = this.image,
    username = this.username
)