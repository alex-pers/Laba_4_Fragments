package com.bgu.laba_4_fragments.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
public abstract class ContactsDataBase : RoomDatabase() {


    abstract fun contactsDao(): ContactsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ContactsDataBase? = null

        fun getDatabase(context: Context): ContactsDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDataBase::class.java,
                    "LABA_4_DB"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}