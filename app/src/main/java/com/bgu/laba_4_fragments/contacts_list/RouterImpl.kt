package com.bgu.laba_4_fragments.contacts_list

import androidx.navigation.NavController
import com.bgu.laba_4_fragments.model.Contact

class RouterImpl(private val navController: NavController): ContactsFragmentContract.Router {
    override fun openContactDescriptionPage(contact: Contact) {
        navController.navigate(ContactsListFragmentDirections.toFragment2(contact))
    }
}