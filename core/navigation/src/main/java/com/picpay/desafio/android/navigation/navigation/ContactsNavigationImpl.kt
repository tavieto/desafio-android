package com.picpay.desafio.android.navigation.navigation

import com.picpay.desafio.android.contacts.data.model.Contact
import com.picpay.desafio.android.contacts.ui.ContactsNavigation
import com.picpay.desafio.android.navigation.core.NavManager
import com.picpay.desafio.android.navigation.destination.LeafDestination

class ContactsNavigationImpl(
    private val navManager: NavManager
): ContactsNavigation {
    override fun test(contact: Contact) {
        navManager.navigate(
            route = LeafDestination.Test.getRoute(contact)
        )
    }
    override fun popBackStack() = navManager.popStackBack()
}
