package com.picpay.desafio.android.repository.datasource.remote

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.commons.base.Either

interface ContactsRemoteDataSource {
    suspend fun getContacts(): Either<List<ContactDomain>>
}
