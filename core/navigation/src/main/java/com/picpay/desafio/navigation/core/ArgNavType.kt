package com.picpay.desafio.navigation.core

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.picpay.desafio.android.core.extension.decode

class ArgNavType<T : Parcelable>(
    private val type: Class<T>,
    isNullableAllowed: Boolean = false
) : NavType<T>(isNullableAllowed = isNullableAllowed){

    override fun get(bundle: Bundle, key: String): T? = bundle.getParcelable(key)

    override fun parseValue(value: String): T = gson.fromJson(value.decode(), type)

    override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)

    companion object {
        private val gson = Gson()
    }
}
