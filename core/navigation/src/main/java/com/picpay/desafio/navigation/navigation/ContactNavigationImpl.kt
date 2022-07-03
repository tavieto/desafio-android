package com.picpay.desafio.navigation.navigation

import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.contact.ui.ContactNavigation
import com.picpay.desafio.navigation.core.NavManager
import com.picpay.desafio.navigation.destination.LeafDestination

class ContactNavigationImpl(
    private val navManager: NavManager
): ContactNavigation {
    override fun test(contact: Contact) {
        navManager.navigate(
            route = LeafDestination.Test.getRoute(contact)
        )
    }
    override fun popBackStack() = navManager.popStackBack()
}
