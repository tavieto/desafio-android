package com.picpay.desafio.android.contacts.usecase

import com.picpay.desafio.android.contacts.data.model.ContactDomain
import com.picpay.desafio.android.contacts.repository.ContactsRepository
import com.picpay.desafio.android.commons.base.Either
import com.picpay.desafio.android.commons.base.UseCase
import kotlinx.coroutines.CoroutineScope

class GetContactsUseCase(
    scope: CoroutineScope,
    private val repository: ContactsRepository
) : UseCase<Unit, List<ContactDomain>>(scope) {
    override suspend fun run(param: Unit?): Either<List<ContactDomain>> {
        return repository.getContacts()
    }
}
