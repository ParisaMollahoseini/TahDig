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
            val view = this
            val builder = AlertDialog.Builder(view)

            // set title
            builder.setTitle("Alert")

            //set content area
            builder.setMessage("Are you sure you want to accept the registration?")

            //set negative button
            builder.setPositiveButton(
                "Yes"
            ) { dialog, id ->

                /// add registration request
                val resName = res_name.text.toString()
                val resbusinessLicenseNumber = businessLicenseNumber.text.toString()
                val resPhone = res_phone.text.toString()

                val res_addr = db.insertAddress(res_city_text.text.toString(),res_street_text.text.toString(),res_alley_text.text.toString(),
                    res_number_text.text.toString().toInt())
                //res_add >>> address id
                if (res_addr != -1.toLong())
                {
                    val query = "Select * from Loggedperson"
//                    val result = db.rawQuery(query, null)
//                    result.moveToFirst()
//                    val ownerUsername = result.getString(result.getColumnIndex("username"))
//                    db.insertNewRequests(resName,ownerUsername,resbusinessLicenseNumber,resPhone,res_addr.toInt())
                }

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
