package com.picpay.desafio.android.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.picpay.desafio.android.contacts.data.model.Contact
import com.picpay.desafio.android.contacts.ui.ContactScreen
import com.picpay.desafio.android.contacts.ui.Test
import com.picpay.desafio.android.navigation.destination.Destination
import com.picpay.desafio.android.navigation.destination.LeafDestination
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
