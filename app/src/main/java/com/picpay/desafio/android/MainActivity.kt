package com.picpay.desafio.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.picpay.desafio.contacts.ui.ContactScreen
import com.picpay.desafio.contacts.ui.ContactViewModel
import com.picpay.desafio.design.theme.PicPayTheme

class MainActivity : ComponentActivity() {

    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicPayTheme {
                ContactScreen(viewModel = ContactViewModel())
            }
        }
    }
}
