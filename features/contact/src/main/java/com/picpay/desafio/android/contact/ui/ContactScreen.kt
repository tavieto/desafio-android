package com.picpay.desafio.android.contact.ui

import android.widget.Toast
import androidx.compose.animation.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.picpay.desafio.android.contact.component.ItemContact
import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.contact.ui.ContactViewAction.*
import com.picpay.desafio.android.contact.ui.ContactViewAction.Set
import com.picpay.desafio.design.R.string.*
import com.picpay.desafio.android.design.theme.PicPayTheme
import com.picpay.desafio.android.design.theme.PicPayTheme.colors
import com.picpay.desafio.android.design.theme.PicPayTheme.spacing

@Composable
fun ContactScreen(viewModel: ContactViewModel) {
    val viewState = viewModel.viewState
    val action: (ContactViewAction) -> Unit = viewModel::dispatchAction
    val context = LocalContext.current

    LaunchedEffect(viewState.isInitialized) {
        if (viewState.isInitialized.not()) {
            action(Set.Initialization)
            action(Get.Contacts)
        }
    }

    LaunchedEffect(viewState.unexpectedError) {
        if (viewState.unexpectedError != null) {
            Toast.makeText(
                context,
                context.getString(error_contacts_default),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Content(viewState, action)
}

@Composable
private fun Content(
    viewState: ContactViewState,
    action: (ContactViewAction) -> Unit
) {
    Surface(color = colors.primary) {
        ContactList(
            contacts = viewState.contacts,
            isLoading = viewState.isLoading,
        ) { action(Navigate.Details) }
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
                text = stringResource(id = content_contacts_title),
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
                        name = contact.name,
                        username = stringResource(id = content_contacts_username, contact.username),
                        photo = contact.image,
                        onClick = { onClick(contact) }
                    )
                }
            }
        }
    }
}
