package com.picpay.desafio.commons.base

sealed class Either<T>{

    data class Success<T>(
        val arg: T
    ): Either<T>()

    data class Failure(
        val error: Throwable
    ): Either<Throwable>()

    fun execute(
        onSuccess: (T) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        when(this) {
            is Failure -> onFailure(this.error)
            is Success -> onSuccess(this.arg)
        }
    }
}
