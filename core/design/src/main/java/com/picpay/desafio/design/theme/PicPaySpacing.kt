package com.picpay.desafio.design.theme

import androidx.compose.ui.unit.Dp
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Lg
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Md
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Mini
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Mlg
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Nano
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.None
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Quark
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Sm
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Unit
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Xl
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Xs
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Xxl
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Xxs
import com.picpay.desafio.design.theme.values.PicPaySpacing.Companion.Xxxs

data class PicPaySpacing(
    val none: Dp = None,
    val unit: Dp = Unit,
    val quark: Dp = Quark,
    val nano: Dp = Nano,
    val mini: Dp = Mini,
    val xxxs: Dp = Xxxs,
    val xxs: Dp = Xxs,
    val xs: Dp = Xs,
    val sm: Dp = Sm,
    val md: Dp = Md,
    val lg: Dp = Lg,
    val mlg: Dp = Mlg,
    val xl: Dp = Xl,
    val xxl: Dp = Xxl
)