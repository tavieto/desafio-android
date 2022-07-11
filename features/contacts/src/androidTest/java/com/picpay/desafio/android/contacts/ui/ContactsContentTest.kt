package com.picpay.desafio.android.contacts.ui

import android.content.Context
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.picpay.desafio.android.contacts.ui.ContactsFactory.VIEW_STATE_LIST
import com.picpay.desafio.android.contacts.ui.ContactsFactory.VIEW_STATE_LOADING
import com.picpay.desafio.android.contacts.R.string.test_tag_item_contact
import com.picpay.desafio.android.contacts.R.string.test_tag_progress
import com.picpay.desafio.android.design.R.string.content_contacts_title
import com.picpay.desafio.android.design.theme.PicPayTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactsContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var context: Context

    @Before
    fun setup() {
        context = getApplicationContext<Context?>().applicationContext
    }

    @Test
    fun verifyIfIsShowingTitle() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LIST) {} } }

        val title = context.getString(content_contacts_title)

        composeTestRule.onNodeWithText(title).assertExists().assertIsDisplayed()
    }

    @Test
    fun verifyIfIsShowingFormatUsername() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LIST) {} } }

        val formatUsername = "@${VIEW_STATE_LIST.contacts[0].username}"

        composeTestRule.onNodeWithText(formatUsername).assertIsDisplayed()
    }

    @Test
    fun verifyIfIsShowingName() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LIST) {} } }

        val name = VIEW_STATE_LIST.contacts[0].name

        composeTestRule.onNodeWithText(name).assertIsDisplayed()
    }

    @Test
    fun verifyIfShowLoading() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LOADING) {} } }

        val progressTag = context.getString(test_tag_progress)

        composeTestRule.onNodeWithTag(progressTag).assertIsDisplayed()
    }

    @Test
    fun verifyIfItemHasMinHeight() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LIST) {} } }

        val itemTag = context.getString(
            test_tag_item_contact,
            VIEW_STATE_LIST.contacts[0].id
        )

        composeTestRule.onNodeWithTag(itemTag).assertHeightIsAtLeast(expectedMinHeight = 48.dp)
    }

    @Test
    fun verifyIfIsShowingAllItems() {
        composeTestRule.setContent { PicPayTheme { ContactContent(VIEW_STATE_LIST) {} } }

        val listTags: List<String> = VIEW_STATE_LIST.contacts.map {
            context.getString(test_tag_item_contact, it.id)
        }

        listTags.forEach {
            composeTestRule.onNodeWithTag(it).assertExists()
        }
    }
}
