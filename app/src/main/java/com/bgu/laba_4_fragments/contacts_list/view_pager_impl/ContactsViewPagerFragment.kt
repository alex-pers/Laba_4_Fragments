package com.bgu.laba_4_fragments.contacts_list.view_pager_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.bgu.laba_4_fragments.R
import com.bgu.laba_4_fragments.contacts_list.ContactsFragmentContract
import com.bgu.laba_4_fragments.contacts_list.ContactsPresenter
import com.bgu.laba_4_fragments.contacts_list.view_pager_impl.ContactFragment.Companion.KEY_CONTACT
import com.bgu.laba_4_fragments.contacts_list.view_pager_impl.ContactFragment.Companion.REQUEST_KEY
import com.bgu.laba_4_fragments.model.Contact

class ContactsViewPagerFragment : Fragment(), ContactsFragmentContract.View {

    lateinit var presenter: ContactsPresenter
    private var actionListener: ContactsFragmentContract.ActionListener? = null
    private lateinit var adapter: ContactsViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        childFragmentManager.setFragmentResultListener(REQUEST_KEY, this) { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val contact = bundle.getSerializable(KEY_CONTACT) as? Contact
            contact?.let {
                actionListener?.onContactClicked(contact)
            }
        }

        super.onCreate(savedInstanceState)

        presenter = ContactsPresenter(requireContext(), object : ContactsFragmentContract.Router {
            override fun openContactDescriptionPage(contact: Contact) {
                findNavController().navigate(
                    ContactsViewPagerFragmentDirections.actionContactsViewPagerFragmentToFragment2(
                        contact
                    )
                )
            }

        })


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ContactsViewPagerAdapter(this)
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.contacts_view_pager)
        viewPager2.adapter = adapter
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }

    override fun showContacts(contacts: List<Contact>) {
        adapter.updateContacts(contacts)
    }

    override fun setActionListener(actionListener: ContactsFragmentContract.ActionListener) {
        this.actionListener = actionListener
    }
}