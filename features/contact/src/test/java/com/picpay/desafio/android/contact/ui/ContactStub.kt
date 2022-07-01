package com.picpay.desafio.android.contact.ui

import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.contact.ui.ContactFactory.LIST_CONTACTS_DOMAIN
import com.picpay.desafio.android.contact.usecase.GetContactsUseCase
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
