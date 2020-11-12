package com.example.fundamentals.IntentServices

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.activity_my_service.*

class MyService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)

        startIS.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                txtstatusIS.text = "Service Running"
            }
        }

        StopIS.setOnClickListener {
            MyIntentService.stopService()
            txtstatusIS.text = "Service Stopped"
        }
    }
}