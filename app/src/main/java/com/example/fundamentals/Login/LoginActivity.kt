package com.example.fundamentals.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentals.Main.MainActivity
import com.example.fundamentals.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth

        login.setOnClickListener {
            SignIn()
        }
    }

    private fun UpdateUI() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun SignIn() {
        if (email.text != null && password.text != null) {
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Sign in Successful", Toast.LENGTH_SHORT).show()
                        UpdateUI()
                    } else {
                        Toast.makeText(this, "Sign in Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
