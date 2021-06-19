package com.axweb.chattwo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axweb.chattwo.R


class ContactsFragment : Fragment() {

    companion object {
        fun newInstance() : ContactsFragment {
            val fragmentContato = ContactsFragment()
            val argumentos = Bundle()
            fragmentContato.arguments = argumentos
            return fragmentContato
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }
}