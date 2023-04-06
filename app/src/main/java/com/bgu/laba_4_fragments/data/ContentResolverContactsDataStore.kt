package com.bgu.laba_4_fragments.data

import com.bgu.laba_4_fragments.model.Contact

interface ContentResolverContactsDataStore {

    fun loadAllContacts(): List<Contact>
}