package com.bgu.laba_4_fragments.model

import com.bgu.laba_4_fragments.model.db.ContactEntity

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val description: String? = ""
) : java.io.Serializable


fun Contact.toContactEntity(): ContactEntity {
    return ContactEntity(
        id = this.id,
        name = this.name,
        phoneNumber = this.phoneNumber,
        description = this.description,
    )
}


