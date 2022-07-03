package com.picpay.desafio.android.navigation.destination

import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.core.extension.encode
import com.picpay.desafio.android.navigation.core.ArgNavType

sealed class Destination(val route: String) {
    object Contacts : Destination(route = "contacts")
}

sealed class LeafDestination(
    val root: Destination,
    private val route: String
) {
    open val arguments: List<NamedNavArgument> = emptyList()
    fun getRoute(): String = "${root.route}/$route"

    object Contacts : LeafDestination(
        root = Destination.Contacts,
        route = "contacts"
    )

    object Test : LeafDestination(
        root = Destination.Contacts,
        route = "test/{contact}"
    ) {
        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(name = "contact") {
                    type = ArgNavType(Contact::class.java)
                }
            )
        fun getRoute(
            contact: Contact
        ) : String = "${root.route}/test/${contact.toNavArg()}"
    }
}

private fun Any?.toNavArg(): String = Gson().toJson(this).encode()
