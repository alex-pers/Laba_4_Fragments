package com.bgu.laba_4_fragments.contacts_list.view_pager_impl

import android.annotation.SuppressLint
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bgu.laba_4_fragments.contacts_list.view_pager_impl.ContactFragment.Companion.KEY_CONTACT
import com.bgu.laba_4_fragments.model.Contact


class ContactsViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var contacts: List<Contact>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun updateContacts(contacts: List<Contact>?) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return contacts?.size ?: 0
    }

    override fun createFragment(position: Int): Fragment {
        return ContactFragment().apply {
            arguments = bundleOf(KEY_CONTACT to contacts!![position])
        }
    }



}
