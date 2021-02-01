package com.example.tahdig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup2.*
class login_signup2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup2)
        val intent1 = Intent(this,signup::class.java)
        val intent2 = Intent(this,MainActivity::class.java)

        logintitle_toolbar.setNavigationOnClickListener(View.OnClickListener() {
            startActivity(intent2)
        });

        accept_button.setOnClickListener {
            //val user = User
            Toast.makeText( this,"You are logged in successfully...", Toast.LENGTH_SHORT).show()

            //check username and password
        }
        register_text.setOnClickListener {
            startActivity(intent1)
        }
    }
}