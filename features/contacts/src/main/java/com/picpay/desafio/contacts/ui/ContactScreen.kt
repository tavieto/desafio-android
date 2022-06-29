package com.picpay.desafio.contacts.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContactScreen() {
    Content()
}

@Composable
private fun Content() {
    Text("Hello, World!")
}

@Preview(showBackground = false)
@Composable
fun ContentPreview() {
    Content()
}