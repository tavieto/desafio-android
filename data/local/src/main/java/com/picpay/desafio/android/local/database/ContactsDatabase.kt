package com.picpay.desafio.android.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.local.dao.ContactsDao
import com.picpay.desafio.android.local.data.model.ContactEntity

@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}
