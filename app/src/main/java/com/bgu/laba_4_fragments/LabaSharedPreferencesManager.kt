package com.bgu.laba_4_fragments

import android.content.Context

class LabaSharedPreferencesManager(private val context: Context) {

    fun setLastContactIdClicked(id: Int) {
        val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val editable = preferences.edit()
        editable.putInt(CONTACT_ID_KEY, id)
        editable.apply()
    }

    fun getLastContactId(): Int {
        val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return preferences.getInt(CONTACT_ID_KEY, 0)
    }

    companion object {
        const val FILE_NAME = "LABA_SHARED_PREFERENCES"
        const val CONTACT_ID_KEY = "CONTACT_ID_KEY"
    }
}