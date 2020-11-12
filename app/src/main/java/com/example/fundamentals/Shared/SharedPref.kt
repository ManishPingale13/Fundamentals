package com.example.fundamentals.Shared

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPref : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnsave.setOnClickListener {
            val name = name.text.toString()
            val age = age.text.toString().toInt()

            editor.apply {
                putString("USER_NAME", name)
                putInt("USER_AGE", age)
            }
            editor.apply()
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
        }

        btnload.setOnClickListener {
            //Null Safety Not Checked
            val user_name: String? = sharedPref.getString("USER_NAME", null)
            val user_age: Int? = sharedPref.getInt("USER_AGE", 0)

            datashowtxt.text = "Name: $user_name \n Age: $user_age"
        }
    }
}