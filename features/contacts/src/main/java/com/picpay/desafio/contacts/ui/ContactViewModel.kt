package com.picpay.desafio.contacts.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.picpay.desafio.contacts.ui.ContactViewAction.Get
import com.picpay.desafio.contacts.ui.ContactViewAction.Navigate
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactViewModel : ViewModel(), KoinComponent {

    private val navigation: ContactNavigation by inject()
    var viewState by mutableStateOf(ContactViewState())
        private set

    fun dispatchAction(viewAction: ContactViewAction) {
        when (viewAction) {
            Get.Contacts -> getContacts()
            Navigate.Details -> navigateDetails()
        }
    }

    private fun getContacts() {
        viewState = viewState.copy(
            contacts = listOf(
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
                "Tavinho",
                "Tavão",
            )
        )
    }

    private fun navigateDetails() {
        navigateDetails()
    }
}
