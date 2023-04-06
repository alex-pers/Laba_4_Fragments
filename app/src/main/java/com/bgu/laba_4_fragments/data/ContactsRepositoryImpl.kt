package com.bgu.laba_4_fragments.data

import com.bgu.laba_4_fragments.model.Contact
import com.bgu.laba_4_fragments.model.db.toContact
import com.bgu.laba_4_fragments.model.toContactEntity

class ContactsRepositoryImpl(
    private val contentResolverContactsDataStore: ContentResolverContactsDataStore,
    private val dataBaseContactsDataStore: DataBaseContactsDataStore
) : ContactsRepository {

    override suspend fun loadAllContacts(): List<Contact> {
        val dbContacts = dataBaseContactsDataStore.loadAllContacts().map { it.toContact() }
        if (dbContacts.isNotEmpty()) {
            return dbContacts
        }
        val contentResolverContacts = contentResolverContactsDataStore.loadAllContacts()
        dataBaseContactsDataStore.saveContacts(contentResolverContacts.map { it.toContactEntity() })
        return contentResolverContacts
    }
}