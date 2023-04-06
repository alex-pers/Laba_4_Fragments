package com.bgu.laba_4_fragments.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bgu.laba_4_fragments.model.Contact


@Entity(tableName = "contacts_table")
class ContactEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val phoneNumber: String,
    val description: String? = ""
)
///-------------------


fun ContactEntity.toContact(): Contact {

    return Contact(
        id = this.id,
        name = this.name,
        phoneNumber = this.phoneNumber,
        description = this.description
    )
}