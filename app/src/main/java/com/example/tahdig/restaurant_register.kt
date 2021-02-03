package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_request_list.*
import kotlinx.android.synthetic.main.activity_restaurant_register.*
import kotlinx.android.synthetic.main.activity_signup.*

class restaurant_register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_register)

        val intent1 = Intent(this,seller_main::class.java)
        val db = DatabaseHandler(this)

        val intent1_3 = intent
        val map_data :HashMap<String,String> = intent1_3.getSerializableExtra("data_array") as HashMap<String, String>


        res_registertitle_toolbar.setNavigationOnClickListener(View.OnClickListener() {
            intent1.putExtra("data_array",map_data)
            startActivity(intent1)
        });

        res_accept_signup_button.setOnClickListener {
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

                /// add registration request
//                val context = this
//                val db = DatabaseHandler(context)
//                db.insertNewRequests()
                /// add registration request

                intent1.putExtra("data_array",map_data)
                startActivity(intent1)
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
