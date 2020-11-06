package com.example.fundamentals.ViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.activity_pagerview.*

class Pagerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagerview)

        val images = listOf(
            R.drawable.billgates,
            R.drawable.elon,
            R.drawable.falcon,
        )

        val adapter = ViewPagerAdapter(images)
        view_pager.adapter = adapter

        view_pager.orientation = ViewPager2.ORIENTATION_VERTICAL

//        view_pager.beginFakeDrag()
//        view_pager.fakeDragBy(-20f)
//        view_pager.endFakeDrag()
    }

}