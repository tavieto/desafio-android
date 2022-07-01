package com.picpay.desafio.android.commons.exception

class NullResponseException(
    message: String? = null,
    title: String? = null
): Throwable(message, Throwable(title))
