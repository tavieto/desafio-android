package com.picpay.desafio.android.navigation.core

sealed class NavigationType {
    object NavigateTo : NavigationType()

    class PopUpTo(val inclusive: Boolean) : NavigationType()
}
