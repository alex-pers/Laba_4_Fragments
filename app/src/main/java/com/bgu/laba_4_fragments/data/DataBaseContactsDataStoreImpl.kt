package com.bgu.laba_4_fragments.data

import com.bgu.laba_4_fragments.model.db.ContactEntity
import com.bgu.laba_4_fragments.model.db.ContactsDao

class DataBaseContactsDataStoreImpl(private val contactsDao: ContactsDao) :
    DataBaseContactsDataStore {

    override suspend fun loadAllContacts(): List<ContactEntity> {
        return contactsDao.loadAllContacts()
    }

    override suspend fun saveContacts(contacts: List<ContactEntity>) {
        contactsDao.saveContacts(contacts)
    }
}