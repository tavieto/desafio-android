package com.picpay.desafio.android.commons.base

sealed class Either<out T> {

    data class Success<T>(val data: T) : Either<T>()
    data class Failure(val error: Throwable) : Either<Nothing>()

    fun execute(
        onSuccess: (T) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        when (this) {
            is Failure -> onFailure(error)
            is Success -> onSuccess(data)
        }
    }
}

inline fun <T> runCatch(callback: () -> T): Either<T> {
    return try {
        Either.Success(callback())
    } catch (throwable: Throwable) {
        Either.Failure(throwable)
    }
}
