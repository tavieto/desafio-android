package com.picpay.desafio.android.contact.repository

import com.picpay.desafio.android.contact.model.UserDomain
import com.picpay.desafio.commons.base.Either

interface ContactsRepository {
    suspend fun getContacts(): Either<List<UserDomain>>
}
