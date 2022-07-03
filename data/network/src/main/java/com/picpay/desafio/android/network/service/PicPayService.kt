package com.picpay.desafio.android.network.service

import com.picpay.desafio.android.network.data.model.ContactResponse
import retrofit2.Response
import retrofit2.http.GET

interface PicPayService {
    @GET("users")
    suspend fun getUsers(): Response<List<ContactResponse>>
}
