package com.picpay.desafio.android.contacts.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import com.picpay.desafio.android.design.theme.PicPayTheme.colors
import com.picpay.desafio.android.design.theme.PicPayTheme.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemContact(
    modifier: Modifier = Modifier,
    name: String,
    username: String,
    photo: String,
    usernameColor: Color = Color.White,
    nameColor: Color = colors.detail,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                role = Role.Button,
                onClick = onClick,
                indication = rememberRipple(color = Color.White),
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(vertical = spacing.nano, horizontal = spacing.xxs)
    ) {
        GlideImage(
            modifier = Modifier
                .size(spacing.lg)
                .clip(RoundedCornerShape(spacing.xxl)),
            imageModel = photo,
            circularReveal = CircularReveal()
        )
        Spacer(modifier = Modifier.width(spacing.nano))
        Column(
            modifier = Modifier
                .padding(vertical = spacing.nano)
                .weight(weight = 1f),
        ) {
            Text(
                text = username,
                color = usernameColor
            )
            Text(
                text = name,
                color = nameColor
            )
        }
        Spacer(modifier = Modifier.width(spacing.xxs))
    }
}
