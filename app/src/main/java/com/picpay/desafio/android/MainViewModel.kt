package com.picpay.desafio.android

import androidx.lifecycle.ViewModel
import com.picpay.desafio.navigation.core.NavManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel: ViewModel(), KoinComponent {

    val navManager: NavManager by inject()
}
