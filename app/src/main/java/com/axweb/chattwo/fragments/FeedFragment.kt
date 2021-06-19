package com.axweb.chattwo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axweb.chattwo.R


class FeedFragment : Fragment() {
    companion object {
        fun newInstance() : FeedFragment {
            val fragmentFeed = FeedFragment()
            val argumentos = Bundle()
            fragmentFeed.arguments = argumentos
            return fragmentFeed
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }
}