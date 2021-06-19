package com.axweb.chattwo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axweb.chattwo.R


class PostFragment : Fragment() {

    companion object {
        fun newInstance() : PostFragment {
            val fragmentPost = PostFragment()
            val argumentos = Bundle()
            fragmentPost.arguments = argumentos
            return fragmentPost
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }
}