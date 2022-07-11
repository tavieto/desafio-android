package com.picpay.desafio.android.local.datasource

import com.picpay.desafio.android.contacts.data.model.ContactDomain
import com.picpay.desafio.android.local.dao.ContactsDao
import com.picpay.desafio.android.local.data.mapper.toDomain
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import com.picpay.desafio.android.commons.base.Either
import com.picpay.desafio.android.commons.base.runCatch
import com.picpay.desafio.android.local.data.mapper.fromDomain

class ContactsLocalDataSourceImpl(
    private val contactsDao: ContactsDao
): ContactsLocalDataSource {
    override suspend fun getContacts(): Either<List<ContactDomain>> = runCatch {
        contactsDao.getContacts().map { it.toDomain() }
    }
    override suspend fun saveContacts(contacts: List<ContactDomain>): Either<Unit> = runCatch {
        contactsDao.saveContacts(*contacts.map { it.fromDomain() }.toTypedArray())
    }
}
