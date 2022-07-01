package com.picpay.desafio.android.commons.exception

class TimeOutException(
    message: String? = null,
    title: String? = null
): Throwable(message, Throwable(title))
