package com.picpay.desafio.android.core

import com.picpay.desafio.android.core.extension.decode
import com.picpay.desafio.android.core.extension.encode
import org.junit.Assert.*
import org.junit.Test

internal class StringExtensionTest {

    @Test
    fun `WHEN encode a String MUST return the original value on decode`() {
        val original = "https://www.picpay.com/site"
        val encoded = original.encode()
        val decoded = encoded.decode()

        assertNotEquals(original, encoded)
        assertEquals(original, decoded)
        assertFalse(encoded.contains('/'))
        assertFalse(encoded.contains(':'))
    }
}
