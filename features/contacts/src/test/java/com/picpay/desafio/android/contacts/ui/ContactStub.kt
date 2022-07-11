package com.picpay.desafio.android.contacts.ui

import com.picpay.desafio.android.contacts.data.model.ContactDomain
import com.picpay.desafio.android.contacts.ui.ContactFactory.LIST_CONTACTS_DOMAIN
import com.picpay.desafio.android.contacts.usecase.GetContactsUseCase
import io.mockk.every
import io.mockk.invoke

class ContactStub(private val useCase: GetContactsUseCase) {

    fun success() {
        every {
            useCase(
                onSuccess = captureLambda(),
                onFailure = any()
            )
        } answers {
            lambda<(List<ContactDomain>) -> Unit>().invoke(LIST_CONTACTS_DOMAIN)
        }
    }

    fun failure() {
        every {
            useCase(
                onSuccess = any(),
                onFailure = captureLambda()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }
}
