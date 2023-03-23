package com.bgu.laba_4_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ContactDescriptionFragment : Fragment() {

    val args: ContactDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.contactName).text = args.contact.name
        view.findViewById<TextView>(R.id.contactNumber).text = args.contact.phoneNumber
        view.findViewById<TextView>(R.id.contactDescription).text = args.contact.description

        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            findNavController().popBackStack()
        }
    }
}