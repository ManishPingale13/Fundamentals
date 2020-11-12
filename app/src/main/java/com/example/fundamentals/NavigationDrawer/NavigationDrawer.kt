package com.example.fundamentals.NavigationDrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.IntentServices.MyService
import com.example.fundamentals.R
import com.example.fundamentals.R.string.close
import com.example.fundamentals.R.string.open
import com.example.fundamentals.Shared.SharedPref
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawer : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        toggle = ActionBarDrawerToggle(this, drawerlay, open, close)
        drawerlay.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.i1 -> {
                    val intent = Intent(this, SharedPref::class.java)
                    startActivity(intent)
                }
                R.id.i2 -> {
                    val intent = Intent(this, MyService::class.java)
                    startActivity(intent)
                }

                R.id.i3 -> Toast.makeText(this, "Clicked Third Item", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}