package com.picpay.desafio.android.commons.exception

class InvalidRequestException(
    message: String? = null,
    title: String? = null
): Throwable(message, Throwable(title))
