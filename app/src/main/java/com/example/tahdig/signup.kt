package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val db = DatabaseHandler(this)




        accept_signup_button.setOnClickListener {
            val addr = Address(city_text.text.toString(),street_text.text.toString(),alley_text.text.toString(),
                number_text.text.toString().toInt())
            db.insertAddress(addr)
            val user_sign = User(username.text.toString(),name.text.toString(),
            password.text.toString(),addr.id)
            db.insertUser(user_sign)

                Toast.makeText( this,"You are signed up successfully..."+addr.id.toString(), Toast.LENGTH_SHORT).show()

            val data = db.readDatauser()
            number_text.text.clear()
            for (i in 0 until data.size) {
                number_text.append(
                    data[i].name + " " + data[i].addressID.toString() + "\n"
                )
            }
        }
    }
}