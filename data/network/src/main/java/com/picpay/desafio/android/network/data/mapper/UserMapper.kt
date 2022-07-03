package com.picpay.desafio.android.network.data.mapper

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.network.data.model.ContactResponse

fun ContactResponse.toDomain() = ContactDomain(
    id = this.id ?: String(),
    name = this.name ?: String(),
    username = this.username ?: String(),
    image = this.image ?: String()
)