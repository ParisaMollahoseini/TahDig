package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        accept_signup_button.setOnClickListener {
            Toast.makeText( this,"You are signed up successfully...", Toast.LENGTH_SHORT).show()
        }
    }
}