package com.picpay.desafio.android.contact.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.picpay.desafio.android.contact.component.ItemContact
import com.picpay.desafio.android.contact.model.User
import com.picpay.desafio.android.contact.ui.ContactViewAction.Get
import com.picpay.desafio.android.contact.ui.ContactViewAction.Navigate
import com.picpay.desafio.design.R.string.*
import com.picpay.desafio.design.theme.PicPayTheme
import com.picpay.desafio.design.theme.PicPayTheme.spacing

@Composable
fun ContactScreen(viewModel: ContactViewModel) {
    val viewState = viewModel.viewState
    val action: (ContactViewAction) -> Unit = viewModel::dispatchAction

    LaunchedEffect(Unit) {
        action(Get.Contacts)
    }

    Content(viewState, action)
}

@Composable
private fun Content(
    viewState: ContactViewState,
    action: (ContactViewAction) -> Unit
) {
    Surface(color = PicPayTheme.colors.primary) {
        ContactList(
            contacts = viewState.contacts,
            isLoading = viewState.isLoading
        ) { action(Navigate.Details) }
    }
}

@Composable
private fun ContactList(
    contacts: List<User>,
    isLoading: Boolean,
    onClick: (User) -> Unit
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
        item {
            Spacer(modifier = Modifier.height(spacing.xxs))
            AnimatedVisibility(
                visible = isLoading,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    color = PicPayTheme.colors.accent,
                    strokeWidth = 4.dp
                )
            }
        }
        items(
            items = contacts,
            key = { it.id }
        ) { contact ->
            ItemContact(
                name = contact.name,
                username = stringResource(id = content_contacts_username, contact.username),
                photo = contact.image,
                onClick = { onClick(contact) }
            )
        }
    }
}