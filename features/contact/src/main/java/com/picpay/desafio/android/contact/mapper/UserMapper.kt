package com.picpay.desafio.android.contact.mapper

import com.picpay.desafio.android.contact.model.User
import com.picpay.desafio.android.contact.model.UserDomain

fun UserDomain.fromDomain() = User(
    id = this.id,
    name = this.name,
    image = this.image,
    username = this.username
)
