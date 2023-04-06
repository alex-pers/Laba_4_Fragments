package com.bgu.laba_4_fragments.contacts_list

import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import com.bgu.laba_4_fragments.LabaSharedPreferencesManager
import com.bgu.laba_4_fragments.model.Contact

class ContactsPresenter(
    private val context: Context,
    private val router: ContactsFragmentContract.Router,
) : ContactsFragmentContract.Presenter {

    private var view: ContactsFragmentContract.View? = null

    private val sharedPreferencesManager = LabaSharedPreferencesManager(context)

    override fun bindView(view: ContactsFragmentContract.View) {
        this.view = view
        view.setActionListener(this)
        loadContacts()
        view?.setLastContactId(sharedPreferencesManager.getLastContactId())
    }

    override fun unbindView() {
        view = null
    }

    override fun onContactClicked(contact: Contact) {
        sharedPreferencesManager.setLastContactIdClicked(contact.id)
        view?.setLastContactId(contact.id)
        router.openContactDescriptionPage(contact)
    }

    private fun loadContacts() {

        val phones = context.contentResolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

        val contacts: MutableList<Contact> = mutableListOf()

        while (phones!!.moveToNext()) {
            val indexId =
                phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
            val indexName =
                phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val indexNumber = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val indexDescription =
                phones.getColumnIndex("account_name")

            phones.columnNames.forEach { column ->
                val index = phones.getColumnIndex(column)
                val value = phones.getString(index)
                Log.d("CONTACT>>", " column $column has value $value")
            }

            Log.d("CONTACT>>", " ---------------------------------------------------")


            val name = phones.getString(indexName)
            val phoneNumber = phones.getString(indexNumber)
            val description = phones.getString(indexDescription)
            val id = phones.getInt(indexId)

            val contactModel = Contact(id, name, phoneNumber, description)
            contacts.add(contactModel)
        }
        phones.close()

        view?.showContacts(contacts)
        view?.setLastContactId(sharedPreferencesManager.getLastContactId())
    }
}