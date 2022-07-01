package com.picpay.desafio.android.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.contact.data.model.ContactDomain
import com.picpay.desafio.android.local.data.model.ContactsEntity

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    fun getContacts(): List<ContactsEntity>

    @Insert(entity = ContactsEntity::class)
    fun saveContacts(vararg contacts: ContactDomain)
}
