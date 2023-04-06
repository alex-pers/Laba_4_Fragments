package com.bgu.laba_4_fragments.contacts_list

import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import com.bgu.laba_4_fragments.LabaSharedPreferencesManager
import com.bgu.laba_4_fragments.data.ContactsRepository
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


//        view?.showContacts(contacts)contact
        view?.setLastContactId(sharedPreferencesManager.getLastContactId())
    }
}