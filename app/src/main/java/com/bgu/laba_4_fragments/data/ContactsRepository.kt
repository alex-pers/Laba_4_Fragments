package com.bgu.laba_4_fragments.data

import com.bgu.laba_4_fragments.model.Contact

interface ContactsRepository {
   suspend fun loadAllContacts(): List<Contact>
}