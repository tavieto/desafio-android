package com.picpay.desafio.design.theme

import androidx.compose.ui.unit.Dp
import com.picpay.desafio.design.theme.values.Spacing.Companion.Lg
import com.picpay.desafio.design.theme.values.Spacing.Companion.Md
import com.picpay.desafio.design.theme.values.Spacing.Companion.Mini
import com.picpay.desafio.design.theme.values.Spacing.Companion.Mlg
import com.picpay.desafio.design.theme.values.Spacing.Companion.Nano
import com.picpay.desafio.design.theme.values.Spacing.Companion.None
import com.picpay.desafio.design.theme.values.Spacing.Companion.Quark
import com.picpay.desafio.design.theme.values.Spacing.Companion.Sm
import com.picpay.desafio.design.theme.values.Spacing.Companion.Unit
import com.picpay.desafio.design.theme.values.Spacing.Companion.Xl
import com.picpay.desafio.design.theme.values.Spacing.Companion.Xs
import com.picpay.desafio.design.theme.values.Spacing.Companion.Xxl
import com.picpay.desafio.design.theme.values.Spacing.Companion.Xxs
import com.picpay.desafio.design.theme.values.Spacing.Companion.Xxxs

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