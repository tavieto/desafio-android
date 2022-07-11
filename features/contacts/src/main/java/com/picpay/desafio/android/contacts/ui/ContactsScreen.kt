package com.picpay.desafio.android.contacts.ui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import com.picpay.desafio.android.contacts.R.string.test_tag_item_contact
import com.picpay.desafio.android.contacts.R.string.test_tag_progress
import com.picpay.desafio.android.contacts.component.ItemContact
import com.picpay.desafio.android.contacts.data.model.Contact
import com.picpay.desafio.android.contacts.ui.ContactsViewAction.*
import com.picpay.desafio.android.contacts.ui.ContactsViewAction.Set
import com.picpay.desafio.android.core.extension.getString
import com.picpay.desafio.android.design.R.string.*
import com.picpay.desafio.android.design.theme.PicPayTheme
import com.picpay.desafio.android.design.theme.PicPayTheme.colors
import com.picpay.desafio.android.design.theme.PicPayTheme.spacing

@Composable
fun ContactScreen(viewModel: ContactsViewModel) {
    val viewState = viewModel.viewState
    val action: (ContactsViewAction) -> Unit = viewModel::dispatchAction

    LaunchedEffect(viewState.isInitialized) {
        if (viewState.isInitialized.not()) {
            action(Set.Initialization)
            action(Get.Contacts)
        }
    }

    ContactContent(viewState, action)
}

@Composable
fun ContactContent(
    viewState: ContacstViewState,
    action: (ContactsViewAction) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(viewState.unexpectedError) {
        if (viewState.unexpectedError != null) {
            Toast.makeText(
                context,
                context.getString(error_contacts_default),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Surface(color = colors.primary) {
        ContactList(
            contacts = viewState.contacts,
            isLoading = viewState.isLoading,
        ) { action(Navigate.Details(it)) }
    }
}

@Composable
private fun ContactList(
    contacts: List<Contact>,
    isLoading: Boolean,
    onClick: (Contact) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = spacing.xxl),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(spacing.mlg))
            Text(
                modifier = Modifier
                    .padding(start = spacing.xxs)
                    .fillMaxWidth(),
                text = content_contacts_title.getString(),
                fontSize = PicPayTheme.fontSize.lg,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(spacing.xxxs))
        }
        if (isLoading) {
            item {
                Spacer(modifier = Modifier.height(spacing.xxs))
                AnimatedVisibility(
                    visible = isLoading,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.testTag(test_tag_progress.getString()),
                        color = colors.accent,
                        strokeWidth = spacing.quark
                    )
                }
            }
        } else {
            items(
                items = contacts,
                key = { it.id }
            ) { contact ->
                AnimatedVisibility(
                    visible = isLoading.not(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    ItemContact(
                        modifier = Modifier.testTag(test_tag_item_contact.getString(contact.id)),
                        name = contact.name,
                        username = content_contacts_username.getString(contact.username),
                        photo = contact.image,
                        onClick = { onClick(contact) }
                    )
                }
            }
        }
    }
}
