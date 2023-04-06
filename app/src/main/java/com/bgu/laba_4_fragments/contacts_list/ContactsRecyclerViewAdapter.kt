package com.bgu.laba_4_fragments.contacts_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bgu.laba_4_fragments.R
import com.bgu.laba_4_fragments.model.Contact


class ContactsRecyclerViewAdapter(
    private val context: Context,
    private val onContactClickListener: OnContactSelected,
) :
    RecyclerView.Adapter<ContactsRecyclerViewAdapter.ContactViewHolder>() {

    interface OnContactSelected {
        fun onContactClicked(contact: Contact)
    }

    private var contacts: List<Contact> = listOf()

    private var lastSelectedContactId: Int? = null
    fun updateLastSelected(lasSelectedId: Int) {
        lastSelectedContactId = lasSelectedId
        notifyDataSetChanged()
    }


    fun updateContacts(items: List<Contact>) {
        contacts = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view, onContactClickListener)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.updateContact(contact, lastSelectedContactId)
    }

    class ContactViewHolder(
        itemView: View,
        private val onContactClickListener: OnContactSelected,
    ) :
        RecyclerView.ViewHolder(itemView) {

        private val userName = itemView.findViewById<TextView>(R.id.contactName)
        private val userNumber = itemView.findViewById<TextView>(R.id.contactNumber)
        private val container = itemView.findViewById<ViewGroup>(R.id.container)

        fun updateContact(contact: Contact, isLastSelectedId: Int?) {
            userName.text = "${contact.id}. ${contact.name}"
            userNumber.text = contact.phoneNumber

            val color = if (isLastSelectedId == contact.id) {
                ContextCompat.getColor(itemView.context, R.color.red_transparent)
            } else {
                ContextCompat.getColor(itemView.context, R.color.white)
            }

            container.setBackgroundColor(color)

            itemView.setOnClickListener {
                onContactClickListener.onContactClicked(contact)
            }
        }

    }


}