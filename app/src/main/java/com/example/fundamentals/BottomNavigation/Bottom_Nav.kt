package com.example.fundamentals.BottomNavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.activity_bottom__nav.*

class Bottom_Nav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom__nav)

        val HomeFragment = HomeFragment()
        val MessagesFragment = MessagesFragment()
        val UsersFragment = UsersFragment()

        setCurrentFragment(HomeFragment)

        mybottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(HomeFragment)
                R.id.message -> setCurrentFragment(MessagesFragment)
                R.id.user -> setCurrentFragment(UsersFragment)
            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myframelay, fragment)
            commit()
        }
    }
}