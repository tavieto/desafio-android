package com.picpay.desafio.android.network.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    inline operator fun <reified T> invoke(
        baseUrl: String
    ): T = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .client(OkHttp())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(T::class.java)

    object OkHttp {
        operator fun invoke(): OkHttpClient = OkHttpClient()
            .newBuilder().apply {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                connectTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                writeTimeout(30, TimeUnit.SECONDS)
            }.build()
    }
}
