package com.picpay.desafio.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.picpay.desafio.navigation.destination.Destination
import com.picpay.desafio.navigation.destination.LeafDestination

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Contacts.route
    ) {
        addContactsGraph()
    }
}
