package com.picpay.desafio.android.network.core

import com.picpay.desafio.android.commons.exception.*
import com.picpay.desafio.android.network.core.NetworkWrapper.StatusCode.BAD_REQUEST
import com.picpay.desafio.android.network.core.NetworkWrapper.StatusCode.NOT_AUTHORIZED
import com.picpay.desafio.android.network.core.NetworkWrapper.StatusCode.NOT_FOUND
import com.picpay.desafio.android.network.core.NetworkWrapper.StatusCode.TIMEOUT
import com.picpay.desafio.android.network.factory.NetworkWrapperFactory.LIST_CONTACTS_RESPONSE
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import retrofit2.Response

internal class NetworkWrapperTest {

    private lateinit var networkWrapper: NetworkWrapper

    @Before
    fun setup() {
        networkWrapper = NetworkWrapper()
    }

    @Test
    fun `WHEN response call has SUCCESS MUST return data`(): Unit = runBlocking {
        val response = Response.success(200, LIST_CONTACTS_RESPONSE)

        val result = networkWrapper { response }

        assertEquals(LIST_CONTACTS_RESPONSE, result)
    }

    @Test
    fun `WHEN response has BAD_REQUEST FAILURE MUST throw InvalidRequestException`() {
        val response = Response.error<Unit>(BAD_REQUEST, byteArrayOf().toResponseBody())

        assertThrows(InvalidRequestException::class.java) {
            runBlocking { networkWrapper { response } }
        }
    }

    @Test
    fun `WHEN response has NOT_AUTHORIZED FAILURE MUST throw NotAuthorizedException`() {
        val response = Response.error<Unit>(NOT_AUTHORIZED, byteArrayOf().toResponseBody())

        assertThrows(NotAuthorizedException::class.java) {
            runBlocking { networkWrapper { response } }
        }
    }

    @Test
    fun `WHEN response has NOT_FOUND FAILURE MUST throw NotFoundException`() {
        val response = Response.error<Unit>(NOT_FOUND, byteArrayOf().toResponseBody())

        assertThrows(NotFoundException::class.java) {
            runBlocking { networkWrapper { response } }
        }
    }

    @Test
    fun `WHEN response has TIMEOUT FAILURE MUST throw TimeOutException`() {
        val response = Response.error<Unit>(TIMEOUT, byteArrayOf().toResponseBody())

        assertThrows(TimeOutException::class.java) {
            runBlocking { networkWrapper { response } }
        }
    }

    @Test
    fun `WHEN response has UNKNOWN FAILURE MUST throw UnknownCodeException`() {
        val response = Response.error<Unit>(500, byteArrayOf().toResponseBody())

        assertThrows(UnknownCodeException::class.java) {
            runBlocking { networkWrapper { response } }
        }
    }
}
