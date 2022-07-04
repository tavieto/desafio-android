package com.picpay.desafio.android.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.picpay.desafio.android.local.ContactsFactory.CONTACT
import com.picpay.desafio.android.local.dao.ContactsDao
import com.picpay.desafio.android.local.database.ContactsDatabase
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactsDatabaseInstrumentedTest {

    private lateinit var contactsDao: ContactsDao
    private lateinit var db: ContactsDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ContactsDatabase::class.java
        ).build()
        contactsDao = db.contactsDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeContactsAndRead() {
        contactsDao.saveContacts(CONTACT)
        val contacts = contactsDao.getContacts()

        Assert.assertTrue(contacts.contains(CONTACT))
    }
}
