package com.picpay.desafio.android.network.data.model

import com.google.gson.annotations.SerializedName

data class ContactResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("img")
    val image: String? = null,
    @SerializedName("username")
    val username: String? = null
)
