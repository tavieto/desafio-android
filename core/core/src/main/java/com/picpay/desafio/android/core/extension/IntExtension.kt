package com.picpay.desafio.android.core.extension

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun Int.getString(@StringRes id: Int): String = stringResource(id = id)

@Composable
fun Int.getString(@StringRes id: Int, vararg args: String): String = stringResource(id = id, args)