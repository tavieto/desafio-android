package com.picpay.desafio.android.repository.datasource.local

import com.picpay.desafio.android.contacts.data.model.ContactDomain
import com.picpay.desafio.android.commons.base.Either

interface ContactsLocalDataSource {
    suspend fun getContacts(): Either<List<ContactDomain>>
    suspend fun saveContacts(contacts: List<ContactDomain>): Either<Unit>
}
