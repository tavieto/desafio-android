package com.picpay.desafio.android.commons.exception

class UnknownCodeException(
    message: String? = null,
    title: String? = null
): Throwable(message, Throwable(title))