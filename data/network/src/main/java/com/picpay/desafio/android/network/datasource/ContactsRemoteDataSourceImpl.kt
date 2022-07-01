package com.picpay.desafio.android.network.datasource

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.network.core.NetworkWrapper
import com.picpay.desafio.android.network.data.mapper.toDomain
import com.picpay.desafio.android.network.service.PicPayService
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import com.picpay.desafio.android.commons.base.Either
import com.picpay.desafio.android.commons.base.runCatch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsRemoteDataSourceImpl(
    private val picPayService: PicPayService
) : ContactsRemoteDataSource, KoinComponent {

    private val networkWrapper: NetworkWrapper by inject()

    override suspend fun getContacts(): Either<List<ContactDomain>> = runCatch {
        networkWrapper {
            picPayService.getUsers()
        }.map {
            it.toDomain()
        }
    }
}
