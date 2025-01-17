package com.picpay.desafio.android.network.datasource

import com.picpay.desafio.android.commons.base.Either.Failure
import com.picpay.desafio.android.commons.base.Either.Success
import com.picpay.desafio.android.network.core.NetworkWrapper
import com.picpay.desafio.android.network.factory.ContactsFactory.LIST_CONTACTS_DOMAIN
import com.picpay.desafio.android.network.factory.ContactsFactory.LIST_CONTACTS_RESPONSE
import com.picpay.desafio.android.network.service.PicPayService
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Response

internal class ContactsRemoteDataSourceTest {

    private lateinit var dataSource: ContactsRemoteDataSource
    private val service: PicPayService = mockk()
    private val networkWrapper: NetworkWrapper = mockk()
    private val moduleTest = module {
        single { networkWrapper }
    }

    @Before
    fun setup() {
        MockKAnnotations.init()
        startKoin { modules(moduleTest) }
        dataSource = ContactsRemoteDataSourceImpl(service)
    }

    @Test
    fun `WHEN run getContacts() and service has SUCCESS MUST convert response to domain model`(): Unit = runBlocking {
        coEvery { service.getUsers() } returns Response.success(LIST_CONTACTS_RESPONSE)

        val result = dataSource.getContacts()

        coVerify(exactly = 1) { service.getUsers() }
        assertEquals(Success(LIST_CONTACTS_DOMAIN), result)
    }

    @Test
    fun `WHEN run getContacts() and service has FAILURE MUST throw exception`(): Unit = runBlocking {
        val throwable = Throwable()
        coEvery { service.getUsers() } throws throwable

        val result = dataSource.getContacts()

        coVerify(exactly = 1) { service.getUsers() }
        assertEquals(Failure(throwable), result)
    }
}
