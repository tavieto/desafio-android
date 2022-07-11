package com.picpay.desafio.android.core

import android.util.Log
import androidx.compose.ui.test.junit4.createComposeRule
import com.picpay.desafio.android.core.extension.getString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class IntExtensionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyIfIsGettingString() {
        var testMessage = String()
        composeTestRule.setContent {
            testMessage = R.string.testing.getString()
        }
        assert(testMessage.isNotBlank())
    }

    @Test
    fun verifyIfIsGettingStringWithArg() {
        val arg = 1
        var testMessage = String()
        composeTestRule.setContent {
            testMessage = R.string.testing_arg.getString(arg)
        }

        assert(testMessage.isNotBlank())
        assert(testMessage.contains(arg.toString()))
    }
}
