package com.picpay.desafio.commons.base

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in Param, T>(
    private val scope: CoroutineScope
) {

    abstract suspend fun run(param: Param?): Either<T>

    operator fun invoke(
        param: Param? = null,
        onFailure: (Throwable) -> Unit = {},
        onSuccess: (T) -> Unit = {}
    ) {
        scope.launch(handleError(onFailure)) {
            run(param).execute(
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
            )
        }
    }

    private fun handleError(
        onError: (Throwable) -> Unit
    ): CoroutineContext = CoroutineExceptionHandler { _, throwable -> onError(throwable) }
}
