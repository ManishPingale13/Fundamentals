package com.example.fundamentals.ServiceI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.R

class MyService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)
    }
}