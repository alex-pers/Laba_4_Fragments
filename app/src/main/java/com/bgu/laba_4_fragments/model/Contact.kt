package com.bgu.laba_4_fragments.model

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val description: String? = ""
) : java.io.Serializable



