package com.picpay.desafio.android.contact.usecase

import com.picpay.desafio.android.contact.model.UserDomain
import com.picpay.desafio.commons.base.Either
import com.picpay.desafio.commons.base.UseCase
import kotlinx.coroutines.CoroutineScope

class GetContactsUseCase(
    scope: CoroutineScope
) : UseCase<Unit, List<UserDomain>>(scope) {
    override suspend fun run(param: Unit?): Either<List<UserDomain>> {
        return Either.Success(
            listOf(
                UserDomain(
                    id = "1",
                    name = "Sandrine Spinka",
                    image = "https://randomuser.me/api/portraits/men/1.jpg",
                    username = "Tod86"
                ),
                UserDomain(
                    id = "2",
                    name = "Sandrine Spinka",
                    image = "https://randomuser.me/api/portraits/men/1.jpg",
                    username = "Tod86"
                ),
                UserDomain(
                    id = "3",
                    name = "Sandrine Spinka",
                    image = "https://randomuser.me/api/portraits/men/1.jpg",
                    username = "Tod86"
                )
            )
        )
    }
}