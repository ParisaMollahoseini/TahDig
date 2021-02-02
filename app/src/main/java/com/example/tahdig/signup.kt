package com.example.tahdig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val intent1 = Intent(this,seller_main::class.java)
        val db = DatabaseHandler(this)


        accept_signup_button.setOnClickListener {

            val res_addr = db.insertAddress(city_text.text.toString(),street_text.text.toString(),alley_text.text.toString(),
                number_text.text.toString().toInt())
            if (res_addr != -1.toLong() )
            {
                val res_user = db.insertUser(username.text.toString(),name.text.toString(),password.text.toString(),res_addr.toInt())
                if(res_user != -1.toLong())
                {
                    Toast.makeText( this,"You are signed up successfully with id: "+res_addr.toString(), Toast.LENGTH_SHORT).show()

                    startActivity(intent1)
                }
            }




        }
    }
}