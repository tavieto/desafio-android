package com.picpay.desafio.android.commons.exception

class NotAuthorizedException(
    message: String? = null,
    title: String? = null
): Throwable(message, Throwable(title))
