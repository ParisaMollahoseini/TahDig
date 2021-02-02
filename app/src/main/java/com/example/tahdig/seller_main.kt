package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seller_main.*
import kotlinx.android.synthetic.main.activity_login_signup2.*

class seller_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller_main)



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
    fun onAlertDialog(view: View) {
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
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()

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