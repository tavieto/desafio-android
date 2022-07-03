package com.picpay.desafio.android.network.core

import com.picpay.desafio.android.commons.exception.*
import retrofit2.Response

class NetworkWrapper {

    companion object StatusCode {
        const val NO_CONTENT = 204
        const val BAD_REQUEST = 400
        const val NOT_AUTHORIZED = 401
        const val NOT_FOUND = 404
        const val TIMEOUT = 408
    }

    suspend inline operator fun <reified T> invoke(crossinline call: suspend () -> Response<T>): T {
        call().let { response ->
            return when {
                response.isSuccessful.not() -> throw handleException(response)
                response.code() == NO_CONTENT && T::class.java == List::class.java -> emptyList<T>() as T
                else -> response.body() ?: throw NullResponseException()
            }
        }
    }

    fun handleException(response: Response<*>): Throwable {
        return when (response.code()) {
            BAD_REQUEST -> InvalidRequestException()
            NOT_AUTHORIZED -> NotAuthorizedException()
            NOT_FOUND -> NotFoundException()
            TIMEOUT -> TimeOutException()
            else -> UnknownCodeException()
        }
    }
}
