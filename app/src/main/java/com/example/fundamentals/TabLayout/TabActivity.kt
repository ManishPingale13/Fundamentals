package com.example.fundamentals.TabLayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.R
import com.example.fundamentals.ViewPager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val images = listOf(
            R.drawable.billgates,
            R.drawable.elon,
            R.drawable.falcon,
        )

        val adapter = ViewPagerAdapter(images)
        mytabviewpager.adapter = adapter

        TabLayoutMediator(mytablayout, mytabviewpager) { tab, pos ->
            tab.text = "Tab ${pos + 1}"
        }.attach()

        mytablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.text} Selected ", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.text} Unselected", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.text} Reselected", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}