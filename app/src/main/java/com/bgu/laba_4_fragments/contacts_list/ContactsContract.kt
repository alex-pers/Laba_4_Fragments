package com.bgu.laba_4_fragments.contacts_list

import com.bgu.laba_4_fragments.model.Contact

class ContactsFragmentContract {

    open interface View {
        fun showContacts(contacts: List<Contact>)
        fun setActionListener(actionListener: ActionListener)
    }

    interface Router {
        fun openContactDescriptionPage(contact: Contact)
    }

    interface ActionListener {
        fun onContactClicked(contact: Contact)
    }

    interface Presenter : ActionListener {
        fun bindView(view: View)
        fun unbindView()
    }
}