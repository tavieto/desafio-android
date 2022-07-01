package com.picpay.desafio.android.contact.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.contact.data.mapper.fromDomain
import com.picpay.desafio.android.contact.ui.ContactViewAction.*
import com.picpay.desafio.android.contact.ui.ContactViewAction.Set
import com.picpay.desafio.android.contact.usecase.GetContactsUseCase
import com.picpay.desafio.android.core.delegate.useCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactViewModel : ViewModel(), KoinComponent {

    private val navigation: ContactNavigation by inject()
    private val getContacts: GetContactsUseCase by useCase()
    var viewState by mutableStateOf(ContactViewState())
        private set

    fun dispatchAction(viewAction: ContactViewAction) {
        when (viewAction) {
            is Clear.Error.Unexpected -> clearErrorUnexpected()
            is Get.Contacts -> getContacts()
            is Navigate.Details -> navigateDetails()
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

    private fun navigateDetails() {
        navigation.details()
    }

    private fun setInitialization() {
        viewState = viewState.copy(isInitialized = true)
    }
}
