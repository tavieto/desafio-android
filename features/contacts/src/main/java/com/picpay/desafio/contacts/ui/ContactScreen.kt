package com.picpay.desafio.contacts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.picpay.desafio.contacts.component.ItemContact
import com.picpay.desafio.contacts.ui.ContactViewAction.Get
import com.picpay.desafio.contacts.ui.ContactViewAction.Navigate
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
    Surface(
        color = PicPayTheme.colors.primary
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = spacing.xxl)
        ) {
            item {
                Spacer(modifier = Modifier.height(spacing.mlg))
                Text(
                    modifier = Modifier.padding(start = spacing.xxs),
                    text = stringResource(id = content_contacts_title),
                    fontSize = PicPayTheme.fontSize.lg,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(spacing.xxxs))
            }
            items(viewState.contacts) { contact ->
                ItemContact(
                    name = contact,
                    username = stringResource(id = content_contacts_username, "lul"),
                    photo = "https://avatars.githubusercontent.com/u/52471672?s=64&v=4",
                    onClick = {
                        action(Navigate.Details)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ContentPreview() {
//    Content(
//        viewState = ContactViewState(),
//        action = {}
//    )
}