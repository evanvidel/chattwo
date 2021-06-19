package com.axweb.chattwo

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.axweb.chattwo.databinding.ActivityMainBinding
import com.axweb.chattwo.fragments.ContactsFragment
import com.axweb.chattwo.fragments.FeedFragment
import com.axweb.chattwo.fragments.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var Content: FrameLayout? = null

    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_feed -> {
               val fragment = FeedFragment.newInstance()
               addFragment(fragment)

            }R.id.action_post -> {
               val fragment = PostFragment.newInstance()
               addFragment(fragment)

            }R.id.action_contatos -> {
               val fragment = ContactsFragment.newInstance()
               addFragment(fragment)
            }
        }
        false
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Content = content
        botton_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        val fragment = FeedFragment.newInstance()
        addFragment(fragment)

    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content,fragment,fragment.javaClass.simpleName)
            .commit()
    }
}
