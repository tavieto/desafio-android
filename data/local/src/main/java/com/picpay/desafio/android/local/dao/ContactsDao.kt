package com.picpay.desafio.android.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.local.data.model.ContactEntity

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    fun getContacts(): List<ContactEntity>

    @Insert(entity = ContactEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveContacts(vararg contacts: ContactEntity)
}
