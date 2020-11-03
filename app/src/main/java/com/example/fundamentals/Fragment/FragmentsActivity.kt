package com.example.fundamentals.Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.activity_fragments.*

class FragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        val FirstFragment = FirstFragment()
        val SecondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myframe, FirstFragment)
            commit()
        }

        f1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.myframe, FirstFragment)
                commit()
            }
        }

        f2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.myframe, SecondFragment)
                commit()
            }
        }
    }
}