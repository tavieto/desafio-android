package com.picpay.desafio.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.contact.ui.ContactScreen
import com.picpay.desafio.android.contact.ui.Test
import com.picpay.desafio.navigation.destination.Destination
import com.picpay.desafio.navigation.destination.LeafDestination
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.addContactsGraph() {
    navigation(
        route = Destination.Contacts.route,
        startDestination = LeafDestination.Contacts.getRoute()
    ) {
        addContacts()
        addTest()
    }
}

private fun NavGraphBuilder.addContacts() {
    composable(
        route = LeafDestination.Contacts.getRoute()
    ) {
        ContactScreen(viewModel = getViewModel())
    }
}

private fun NavGraphBuilder.addTest() {
    composable(
        route = LeafDestination.Test.getRoute(),
        arguments = LeafDestination.Test.arguments
    ) { backStackEntry ->
        val default = Contact(
            id = String(),
            name = String(),
            image = String(),
            username = String()
        )
        val contact = backStackEntry.arguments?.getParcelable("contact") ?: default
        Test(
            viewModel = getViewModel(),
            contact = contact
        )
    }
}
