package com.picpay.desafio.android.contact.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.contact.mapper.fromDomain
import com.picpay.desafio.android.contact.ui.ContactViewAction.Get
import com.picpay.desafio.android.contact.ui.ContactViewAction.Navigate
import com.picpay.desafio.android.contact.usecase.GetContactsUseCase
import com.picpay.desafio.core.delegate.useCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactViewModel : ViewModel(), KoinComponent {

    private val navigation: ContactNavigation by inject()
    private val getContacts: GetContactsUseCase by useCase()
    var viewState by mutableStateOf(ContactViewState())
        private set

    fun dispatchAction(viewAction: ContactViewAction) {
        when (viewAction) {
            Get.Contacts -> getContacts()
            Navigate.Details -> navigateDetails()
        }
    }

    private fun getContacts() {
        getContacts(
            onSuccess = { contacts ->
                viewState = viewState.copy(
                    contacts = contacts.map { it.fromDomain() },
                    isLoading = false
                )
            },
            onFailure = {
                viewState = viewState.copy(
                    isLoading = false
                )
            }
        )
    }

    private fun navigateDetails() {
        navigation.details()
    }
}
