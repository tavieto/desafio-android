package com.picpay.desafio.android.repository.repository

import com.picpay.desafio.android.commons.base.Either
import com.picpay.desafio.android.commons.base.Either.Success
import com.picpay.desafio.android.contact.repository.ContactsRepository
import com.picpay.desafio.android.repository.datasource.local.ContactsLocalDataSource
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import com.picpay.desafio.android.repository.factory.ContactsFactory.LIST_CONTACTS
import com.picpay.desafio.android.repository.factory.ContactsFactory.LIST_CONTACTS_LOCAL
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class ContactsRepositoryTest {

    private lateinit var repository: ContactsRepository
    private val contactsLocal: ContactsLocalDataSource = mockk()
    private val contactsRemote: ContactsRemoteDataSource = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        repository = ContactsRepositoryImpl(contactsLocal, contactsRemote)
    }

    @Test
    fun `WHEN run getContacts() and remote data has SUCCESS MUST save on local and return local data`(): Unit = runBlocking {
        coEvery { contactsRemote.getContacts() } returns Success(LIST_CONTACTS)
        coEvery { contactsLocal.getContacts() } returns Success(LIST_CONTACTS)
        coEvery { contactsLocal.saveContacts(any()) } returns Success(Unit)

        val response = repository.getContacts()

        coVerify(exactly = 1) { contactsRemote.getContacts() }
        coVerify(exactly = 1) { contactsLocal.saveContacts(any()) }
        coVerify(exactly = 1) { contactsLocal.getContacts() }
        Assert.assertEquals(Success(LIST_CONTACTS), response)
    }

    @Test
    fun `WHEN run getContacts() and remote data has FALIURE MUST call local and return local data`(): Unit = runBlocking {
        coEvery { contactsRemote.getContacts() } returns Either.Failure(Throwable())
        coEvery { contactsLocal.getContacts() } returns Success(LIST_CONTACTS_LOCAL)
        coEvery { contactsLocal.saveContacts(any()) } returns Success(Unit)

        val response = repository.getContacts()

        coVerify(exactly = 1) { contactsRemote.getContacts() }
        coVerify(exactly = 0) { contactsLocal.saveContacts(any()) }
        coVerify(exactly = 1) { contactsLocal.getContacts() }
        Assert.assertEquals(Success(LIST_CONTACTS_LOCAL), response)
    }

    @Test
    fun `WHEN run saveContacts() and local data has SUCCESS MUST return Success`(): Unit = runBlocking {
        coEvery { contactsLocal.saveContacts(any()) } returns Success(Unit)

        val response = repository.saveContacts(LIST_CONTACTS)

        coVerify(exactly = 1) { contactsLocal.saveContacts(any()) }
        Assert.assertTrue(response is Success)
    }

    @Test
    fun `WHEN run saveContacts() and local data has FAILURE MUST return Failure`(): Unit = runBlocking {
        coEvery { contactsLocal.saveContacts(any()) } returns Either.Failure(Throwable())

        val response = repository.saveContacts(LIST_CONTACTS)

        coVerify(exactly = 1) { contactsLocal.saveContacts(any()) }
        Assert.assertTrue(response is Either.Failure)
    }
}
