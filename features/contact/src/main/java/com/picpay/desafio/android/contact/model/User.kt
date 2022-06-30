package com.picpay.desafio.android.contact.model

data class User(
    val id: String,
    val name: String,
    val image: String,
    val username: String
) {
    fun toDomain() = UserDomain(
        id = this.id,
        name = this.name,
        image = this.image,
        username = this.username
    )
}
