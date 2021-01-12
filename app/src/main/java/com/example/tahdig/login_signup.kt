package com.example.tahdig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup.*

class login_signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        val intent1 = Intent(this,signup::class.java)

        accept_button.setOnClickListener {
            Toast.makeText( this,"You are logged in successfully...", Toast.LENGTH_SHORT).show()

            //check username and password
        }
        register_text.setOnClickListener {
            startActivity(intent1)
        }
    }
}