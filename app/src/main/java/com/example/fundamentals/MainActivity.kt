package com.example.fundamentals

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val button = findViewById<Button>(R.id.permissionbutton)

        button.setOnClickListener {
            requestpermissions()
        }

    }

    private fun Permission1() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED

    private fun Permission2() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun Permission3() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun requestpermissions() {
        var permissionstoreq = mutableListOf<String>()
        if (!Permission1())
            permissionstoreq.add(Manifest.permission.CAMERA)
        if (!Permission2())
            permissionstoreq.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        if (!Permission3())
            permissionstoreq.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)

        if (permissionstoreq.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionstoreq.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("MainActivity", "onRequestPermissionsResult: ${permissions[i]} Granted!")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentuser = auth.currentUser
        if (currentuser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}