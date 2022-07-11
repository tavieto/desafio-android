package com.picpay.desafio.android.contacts.usecase

import com.picpay.desafio.android.commons.base.Either.Failure
import com.picpay.desafio.android.commons.base.Either.Success
import com.picpay.desafio.android.contacts.factory.GetContactsFactory.LIST_CONTACTS
import com.picpay.desafio.android.contacts.repository.ContactsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class GetContactsUseCaseTest {
    private lateinit var useCase: GetContactsUseCase
    private val repository: ContactsRepository = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        useCase = GetContactsUseCase(
            scope = CoroutineScope(Dispatchers.Unconfined),
            repository = repository
        )
    }

    @Test
    fun `WHEN run use case MUST call repository once`(): Unit = runBlocking {
        coEvery { repository.getContacts() } returns Success(LIST_CONTACTS)

        useCase.run(Unit)

        coVerify(exactly = 1) { repository.getContacts() }
    }

    @Test
    fun `WHEN repository fail MUST be FAILURE`(): Unit = runBlocking {
        coEvery { repository.getContacts() } returns Failure(Throwable())

        val result = useCase.run(Unit)

        Assert.assertTrue(result is Failure)
    }

    @Test
    fun `WHEN repository has success MUST be SUCCESS`(): Unit = runBlocking {
        coEvery { repository.getContacts() } returns Success(LIST_CONTACTS)

        val result = useCase.run(Unit)

        Assert.assertTrue(result is Success)
    }
}
