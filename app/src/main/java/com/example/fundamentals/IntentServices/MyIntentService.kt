package com.example.fundamentals.IntentServices

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("My Intent Service") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isrunning = false

        fun stopService() {
            isrunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isrunning = true
            while (isrunning) {
                Log.d("TAG", "onHandleIntent:Intent Service RUNNING.... ")
                Thread.sleep(1000)
            }
        } catch (e: Exception) {
            Thread.currentThread().interrupt()
        }
    }

}