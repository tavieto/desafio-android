package com.picpay.desafio.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.picpay.desafio.android.ui.ContactScreen

class MainActivity : ComponentActivity() {

    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            ContactScreen()
        }
    }
}
