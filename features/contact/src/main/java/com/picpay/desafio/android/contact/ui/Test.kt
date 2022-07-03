package com.picpay.desafio.android.contact.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.picpay.desafio.android.contact.data.model.Contact
import com.picpay.desafio.android.design.R
import com.picpay.desafio.android.design.theme.PicPayTheme
import com.picpay.desafio.android.design.theme.PicPayTheme.spacing
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Test(
    viewModel: ContactViewModel,
    contact: Contact
) {
    Surface(
        color = PicPayTheme.colors.picPay
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TestToolbar { viewModel.dispatchAction(ContactViewAction.Navigate.PopBackStack) }
            TestContentBody(contact)
        }
    }
}

@Composable
fun ColumnScope.TestContentBody(
    contact: Contact
) {
    this.apply {
        Column(
            modifier = Modifier.weight(weight = 1f).fillMaxWidth(),
            horizontalAlignment = CenterHorizontally
        ) {
            GlideImage(
                modifier = Modifier
                    .size(spacing.xxl)
                    .clip(RoundedCornerShape(spacing.xxl)),
                imageModel = contact.image,
                circularReveal = CircularReveal()
            )
            Spacer(modifier = Modifier.height(spacing.xxs))
            Text(
                text = stringResource(id = R.string.content_test_username, contact.username),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(spacing.nano))
            Text(
                text = stringResource(id = R.string.content_test_name, contact.name),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    }
}

@Composable
private fun TestToolbar(navigation: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = spacing.nano, bottom = spacing.xxs)
    ) {
        IconButton(onClick = navigation) {
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(spacing.xxl),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(id = R.string.accessibility_test_back),
                tint = Color.White
            )
        }
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .width(spacing.xxl),
            painter = painterResource(id = R.drawable.ic_picpay),
            contentDescription = stringResource(id = R.string.accessibility_test_pic_pay_logo),
            tint = Color.White
        )
    }
}
