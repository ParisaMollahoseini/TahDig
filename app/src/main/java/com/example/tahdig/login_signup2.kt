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
        val intent3 = Intent(this,seller_main::class.java)
        val intent4 = Intent(this,AdminMainActivity::class.java)

        logintitle_toolbar.setNavigationOnClickListener(View.OnClickListener() {
            startActivity(intent2)
        });

        accept_button.setOnClickListener {
            val context = this
            val db = DatabaseHandler(context)

            val data = db.readDatauser()
            var flag = 0

            if(Username.text.toString().equals("admin") && Password.text.toString().equals("1234"))
            {
                startActivity(intent4)
            }
            for (i in 0 until data.size) {

                if(data[i].username.equals(Username.text.toString()) && data[i].password.equals(Password.text.toString()))
                {
                    flag = 1
                    Toast.makeText( this,"You are logged in successfully...", Toast.LENGTH_SHORT).show()
                    db.insertLoggedperson(Username.toString(),Password.toString())
                    startActivity(intent3)
                }
            }
            if(flag == 0 )
                Toast.makeText( this,"Logging failed ...", Toast.LENGTH_SHORT).show()

        }
        register_text.setOnClickListener {
            startActivity(intent1)
        }
    }
}