package com.bgu.laba_4_fragments.contacts_list.view_pager_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.bgu.laba_4_fragments.R
import com.bgu.laba_4_fragments.model.Contact

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contact = arguments?.getSerializable(KEY_CONTACT) as? Contact

        view.setOnClickListener {
            setFragmentResult(REQUEST_KEY, bundleOf(KEY_CONTACT to contact))
        }

        val userName = view.findViewById<TextView>(R.id.contactName)
        val userPhoneNumber = view.findViewById<TextView>(R.id.contactNumber)

        contact?.let {
            userName.text = it.name
            userPhoneNumber.text = it.phoneNumber
        }
    }

    companion object {
        const val KEY_CONTACT = "KEY_CONTACT"
        const val REQUEST_KEY = "REQUEST_KEY"
    }
}