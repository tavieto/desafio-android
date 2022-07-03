package com.picpay.desafio.android.network.datasource

import com.picpay.desafio.android.commons.base.Either
import com.picpay.desafio.android.commons.base.Either.Success
import com.picpay.desafio.android.network.core.NetworkWrapper
import com.picpay.desafio.android.network.factory.ContactsFactory
import com.picpay.desafio.android.network.factory.ContactsFactory.LIST_CONTACTS_DOMAIN
import com.picpay.desafio.android.network.factory.ContactsFactory.LIST_CONTACTS_RESPONSE
import com.picpay.desafio.android.network.service.PicPayService
import com.picpay.desafio.android.repository.datasource.remote.ContactsRemoteDataSource
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
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
        assertTrue(result is Success)
        assertEquals(LIST_CONTACTS_DOMAIN, (result as Success).data)
    }
}
