package com.picpay.desafio.android.design.theme

import androidx.compose.ui.unit.TextUnit
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Display
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Default
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Xxxs
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Xxs
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Xs
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Sm
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Md
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Lg
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Xxl
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Xl
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Giant
import com.picpay.desafio.android.design.theme.values.FontSize.Companion.Mini

data class PicPayFontSize(
    val default: TextUnit = Default,
    val mini: TextUnit = Mini,
    val xxxs: TextUnit = Xxxs,
    val xxs: TextUnit = Xxs,
    val xs: TextUnit = Xs,
    val sm: TextUnit = Sm,
    val md: TextUnit = Md,
    val lg: TextUnit = Lg,
    val xl: TextUnit = Xl,
    val xxl: TextUnit = Xxl,
    val giant: TextUnit = Giant,
    val display: TextUnit = Display
)