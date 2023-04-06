package com.bgu.laba_4_fragments.data

import com.bgu.laba_4_fragments.model.db.ContactEntity

interface DataBaseContactsDataStore {

    suspend fun loadAllContacts(): List<ContactEntity>

    suspend fun saveContacts(contacts: List<ContactEntity>)
}