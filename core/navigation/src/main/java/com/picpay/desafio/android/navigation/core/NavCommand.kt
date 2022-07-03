package com.picpay.desafio.android.navigation.core

import androidx.navigation.NavOptions

sealed class NavCommand {
    data class Navigate(
        val destination: String,
        val navOptions: NavOptions? = null,
        val type: NavigationType,
    ) : NavCommand()

    object NavigateUp : NavCommand()

    object PopStackBack : NavCommand()
}
