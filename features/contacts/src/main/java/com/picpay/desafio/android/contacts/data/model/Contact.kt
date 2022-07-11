package com.picpay.desafio.android.contacts.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: String,
    val name: String,
    val image: String,
    val username: String
): Parcelable
