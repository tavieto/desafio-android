package com.picpay.desafio.design.theme

import androidx.compose.ui.unit.TextUnit
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Display
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Default
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Xxxs
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Xxs
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Xs
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Sm
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Md
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Lg
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Xxl
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Xl
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Giant
import com.picpay.desafio.design.theme.values.PicPayFontSize.Companion.Mini

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