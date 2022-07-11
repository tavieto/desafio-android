package com.picpay.desafio.android.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun Int.getString(): String = stringResource(id = this)

@Composable
fun Int.getString(vararg args: Any): String = stringResource(id = this, *args)
