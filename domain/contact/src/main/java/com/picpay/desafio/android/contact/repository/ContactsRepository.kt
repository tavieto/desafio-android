package com.picpay.desafio.android.contact.repository

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.commons.base.Either

interface ContactsRepository {
    suspend fun getContacts(): Either<List<ContactDomain>>
    suspend fun saveContacts(contacts: List<ContactDomain>): Either<Unit>
}
