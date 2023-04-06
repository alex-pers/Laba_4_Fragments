package com.bgu.laba_4_fragments.contacts_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bgu.laba_4_fragments.R
import com.bgu.laba_4_fragments.model.Contact

class ContactsListFragment : Fragment(), ContactsFragmentContract.View,
    ContactsRecyclerViewAdapter.OnContactSelected {

    lateinit var presenter: ContactsPresenter
    private var actionListener: ContactsFragmentContract.ActionListener? = null

    lateinit var contactsAdapter: ContactsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ContactsPresenter(
            requireContext(),
            RouterImpl(findNavController()),
            )

        contactsAdapter = ContactsRecyclerViewAdapter(requireContext(), this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.contacts_list)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = contactsAdapter

        presenter.bindView(this)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }

    override fun showContacts(contacts: List<Contact>) {
        contactsAdapter.updateContacts(contacts)
    }

    override fun setActionListener(actionListener: ContactsFragmentContract.ActionListener) {
        this.actionListener = actionListener
    }

    override fun setLastContactId(id: Int) {
        contactsAdapter.updateLastSelected(id)
    }

    override fun onContactClicked(contact: Contact) {
        actionListener?.onContactClicked(contact)
        contactsAdapter.updateLastSelected(contact.id)
    }
}