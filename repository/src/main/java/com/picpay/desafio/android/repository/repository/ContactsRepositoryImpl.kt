package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.contact.repository.ContactsRepository
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import com.picpay.desafio.android.commons.base.Either

class ContactsRepositoryImpl(
    private val contactsLocal: ContactsLocalDataSource,
    private val contactsRemote: ContactsRemoteDataSource
): ContactsRepository {
    override suspend fun getContacts(): Either<List<ContactDomain>> {
        return when (val result = contactsRemote.getContacts()) {
            is Either.Failure -> contactsLocal.getContacts()
            is Either.Success -> {
                saveContacts(result.data)
                contactsLocal.getContacts()
            }
        }
    }

    override suspend fun saveContacts(contacts: List<ContactDomain>): Either<Unit> {
        return contactsLocal.saveContacts(contacts)
    }
}
