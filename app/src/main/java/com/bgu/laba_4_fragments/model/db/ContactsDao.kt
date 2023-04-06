package com.bgu.laba_4_fragments.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactsDao {

    @Query("SELECT * FROM contacts_table ORDER BY id")
    suspend fun loadAllContacts(): List<ContactEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveContacts(contacts: List<ContactEntity>)
}