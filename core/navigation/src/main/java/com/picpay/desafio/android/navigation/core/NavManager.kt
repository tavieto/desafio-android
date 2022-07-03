package com.picpay.desafio.android.navigation.core

import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NavManager(private val scope: CoroutineScope) {
    private val _commands: Channel<NavCommand> = Channel(Channel.BUFFERED)
    val commands = _commands.receiveAsFlow()

    private fun navigate(
        route: String,
        navOptions: NavOptions? = null
    ) {
        scope.launch {
            _commands.send(
                NavCommand.Navigate(
                    destination = route,
                    navOptions = navOptions,
                    type = NavigationType.NavigateTo
                )
            )
        }
    }

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = navOptionsDefault
    ) {
        navigate(
            route = route,
            navOptions = navOptions(optionsBuilder = builder)
        )
    }

    fun navigateUp() {
        scope.launch {
            _commands.send(
                NavCommand.NavigateUp
            )
        }
    }

    fun popStackTo(route: String, inclusive: Boolean) {
        scope.launch {
            _commands.send(
                NavCommand.Navigate(
                    destination = route,
                    type = NavigationType.PopUpTo(inclusive)
                )
            )
        }
    }

    fun popStackBack() {
        scope.launch {
            _commands.send(NavCommand.PopStackBack)
        }
    }

    companion object {
        private val navOptionsDefault: NavOptionsBuilder.() -> Unit = {
            launchSingleTop = true
        }
    }
}



