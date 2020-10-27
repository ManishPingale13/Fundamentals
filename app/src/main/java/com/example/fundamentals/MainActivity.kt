package com.example.fundamentals

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        var todolist = mutableListOf(
            ToDo("Coding", true),
            ToDo("Cycling", true),
            ToDo("Recycling", false),
            ToDo("Reading", true),
            ToDo("Calling doctor ", false),
            ToDo("Playing", false)
        )

        val adapter = TodoAdapter(todolist)
        myrecycleview.adapter = adapter
        myrecycleview.layoutManager = LinearLayoutManager(this)

        val Dialogs = Dialogs(this)

        d1.setOnClickListener {
            Dialogs.Dialog1()
        }

        d2.setOnClickListener {
            Dialogs.Dialog2()
        }

        d3.setOnClickListener {
            Dialogs.Dialog3()
        }

        permissionbutton.setOnClickListener {
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
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings ->
                Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show()
            R.id.addcontact ->
                Toast.makeText(this, "Clicked Add Person", Toast.LENGTH_SHORT).show()
            R.id.favorite ->
                Toast.makeText(this, "Clicked Favourites", Toast.LENGTH_SHORT).show()
            R.id.rateus ->
                Toast.makeText(this, "Clicked Rate us", Toast.LENGTH_SHORT).show()
            R.id.feedback ->
                Toast.makeText(this, "Clicked feedback", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}