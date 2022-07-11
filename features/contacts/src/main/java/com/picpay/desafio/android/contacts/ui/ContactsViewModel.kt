package com.picpay.desafio.android.contacts.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.contacts.data.mapper.fromDomain
import com.picpay.desafio.android.contacts.data.model.Contact
import com.picpay.desafio.android.contacts.ui.ContactsViewAction.*
import com.picpay.desafio.android.contacts.ui.ContactsViewAction.Set
import com.picpay.desafio.android.contacts.usecase.GetContactsUseCase
import com.picpay.desafio.android.core.delegate.useCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsViewModel : ViewModel(), KoinComponent {

    private val navigation: ContactsNavigation by inject()
    private val getContacts: GetContactsUseCase by useCase()
    var viewState by mutableStateOf(ContacstViewState())
        private set

    fun dispatchAction(viewAction: ContactsViewAction) {
        when (viewAction) {
            is Clear.Error.Unexpected -> clearErrorUnexpected()
            is Get.Contacts -> getContacts()
            is Navigate.Details -> navigateDetails(viewAction.contact)
            is Navigate.PopBackStack -> navigatePopBackStack()
            is Set.Initialization -> setInitialization()
        }
    }

    private fun clearErrorUnexpected() {
        viewState = viewState.copy(unexpectedError = null)
    }

    private fun getContacts() {
        dispatchAction(Clear.Error.Unexpected)
        viewState = viewState.copy(isLoading = true)
        getContacts(
            onSuccess = { contacts ->
                viewState = viewState.copy(
                    contacts = contacts.map { it.fromDomain() },
                    isLoading = false
                )
            },
            onFailure = {
                viewState = viewState.copy(
                    isLoading = false,
                    unexpectedError = it
                )
            }
        )
    }

    private fun navigateDetails(contact: Contact) {
        navigation.test(contact = contact)
    }

    private fun navigatePopBackStack() {
        navigation.popBackStack()
    }

    private fun setInitialization() {
        viewState = viewState.copy(isInitialized = true)
    }
}
