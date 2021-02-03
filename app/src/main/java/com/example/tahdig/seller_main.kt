package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_main.*
import kotlinx.android.synthetic.main.activity_seller_main.*
import kotlinx.android.synthetic.main.activity_login_signup2.*
import kotlinx.android.synthetic.main.activity_seller_main.sellertitle_toolbar
import kotlinx.android.synthetic.main.seller_no_restaurant.*

class seller_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //res num
        val intent1_3 = intent
        val map_data :HashMap<String,String> = intent1_3.getSerializableExtra("data_array") as HashMap<String, String>
        val res_num = map_data["res_no"].toString().toInt()
        //res num


        if (res_num == 0) {

            setContentView(R.layout.seller_no_restaurant)
            val intent2 = Intent(this, restaurant_register::class.java)
            val context = this
            val db = DatabaseHandler(context).readableDatabase

            val query = "Select * from Loggedperson"
            val result = db.rawQuery(query, null)
            result.moveToFirst()
            val username1 = result.getString(result.getColumnIndex("username"))
            sellertitle_toolbar_norest.setTitle(username1)
            result.close()

            sellertitle_toolbar_norest.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_seller_logout_norest -> {
                        onAlertDialog(sellertitle_toolbar_norest)
                        return@setOnMenuItemClickListener true
                    }

                }
                return@setOnMenuItemClickListener false
            }
            title_norest.setOnClickListener {
                intent2.putExtra("data_array",map_data)
                startActivity(intent2)
            }
        }
            else {
            setContentView(R.layout.activity_seller_main)
            val context = this
            val db = DatabaseHandler(context).readableDatabase

            val query = "Select * from Loggedperson"
            val result = db.rawQuery(query, null)
            result.moveToFirst()
            val username1 = result.getString(result.getColumnIndex("username"))
            //////////////////////////////////
            sellertitle_toolbar.setTitle(username1)
            result.close()
            db.close()

            ///from restaurant

            seller_title.text = "resname"

            ///from restaurant
            //add_menu1
            sellertitle_toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_seller_logout -> {
                        onAlertDialog(sellertitle_toolbar)
                        return@setOnMenuItemClickListener true
                    }

                }
                return@setOnMenuItemClickListener false
            }
        }
    }

    fun onAlertDialog(view: View) {

        val map_data :HashMap<String,String> = getIntent().getSerializableExtra("data_array") as HashMap<String, String>

        val intent1 = Intent(this, login_signup2::class.java)

        //Instantiate builder variable
        val builder = AlertDialog.Builder(view.context)

        // set title
        builder.setTitle("Alert")

        //set content area
        builder.setMessage("Are you sure you want to logOut ?")

        //set negative button
        builder.setPositiveButton(
            "Yes"
        ) { dialog, id ->
            // User clicked Update Now button
            val context = this
            val db = DatabaseHandler(context).writableDatabase
            db.delete("Loggedperson", null, null)
            db.close()
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
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