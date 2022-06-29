package com.picpay.desafio.design.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

private val LocalPicPaySpacing = compositionLocalOf { PicPaySpacing() }
private val LocalPicPayColors = compositionLocalOf { PicPayColors() }
private val LocalPicPayFontSize = compositionLocalOf { PicPayFontSize() }

@Composable
fun PicPayTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalPicPaySpacing provides PicPaySpacing(),
        LocalPicPayColors provides PicPayColors(),
        LocalPicPayFontSize provides PicPayFontSize()
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object PicPayTheme {
    val spacing: PicPaySpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalPicPaySpacing.current
    val colors: PicPayColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPicPayColors.current
    val fontSize: PicPayFontSize
        @Composable
        @ReadOnlyComposable
        get() = LocalPicPayFontSize.current
}
