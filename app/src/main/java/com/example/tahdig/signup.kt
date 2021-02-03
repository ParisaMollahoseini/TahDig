package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup2.*
import kotlinx.android.synthetic.main.activity_request_list.*
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val intent1 = Intent(this,seller_main::class.java)
        val intent2 = Intent(this,login_signup2::class.java)
        val db = DatabaseHandler(this)

        val intent1_3 = intent
        val map_data :HashMap<String,String> = intent1_3.getSerializableExtra("data_array") as HashMap<String, String>


        registertitle_toolbar.setNavigationOnClickListener(View.OnClickListener() {
            intent2.putExtra("data_array",map_data)
            startActivity(intent2)
        });
        accept_signup_button.setOnClickListener {
//Instantiate builder variable
            val view = listView
            val builder = AlertDialog.Builder(view.context)

            // set title
            builder.setTitle("Alert")

            //set content area
            builder.setMessage("Are you sure you want to accept the registration?")

            //set negative button
            builder.setPositiveButton(
                "Yes"
            ) { dialog, id ->
                // User clicked Update Now button
                val res_addr = db.insertAddress(city_text.text.toString(),street_text.text.toString(),alley_text.text.toString(),
                    number_text.text.toString().toInt())
                if (res_addr != -1.toLong() )
                {
                    val res_user = db.insertUser(username.text.toString(),name.text.toString(),password.text.toString(),res_addr.toInt())
                    if(res_user != -1.toLong())
                    {
                        Toast.makeText( this,"You are signed up successfully with id: "+res_addr.toString(), Toast.LENGTH_SHORT).show()
                        db.insertLoggedperson(username.text.toString(),password.text.toString())
                        map_data.put("res_no","0")
                        intent1.putExtra("data_array",map_data)
                        db.close()
                        startActivity(intent1)
                    }
                }

            }

            //set positive button
            builder.setNegativeButton(
                "No"
            ) { dialog, id ->
                // User cancelled the dialog
            }
            builder.show()

        }
    }

}