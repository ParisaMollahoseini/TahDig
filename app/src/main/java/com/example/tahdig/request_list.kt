package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup2.*
import kotlinx.android.synthetic.main.activity_request_list.*
import java.sql.SQLException

class request_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_list)
        var itemlist = arrayListOf<String>()
        var adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, itemlist)

        //check number of req
        var req_num = 0
        //check number of req
        //get list of req

        //add list of req to ui
        val context = this
        val db = DatabaseHandler(context)

        listView.adapter = adapter
        val data = db.readDatareq()
        for (i in 0 until data.size) {

            itemlist.add(
                "businessLicenseNumber: " + data[i].businessLicenseNumber +
                        "\nowner name: " + data[i].ownerUsername + "\nphone number: " + data[i].phoneNumber
                        + "\nAddress id: " + data[i].addressID
            )

            adapter.notifyDataSetChanged()
        }
        //add list of req to ui
        accept.setOnClickListener {
            //Instantiate builder variable
            val view = listView
            val builder = AlertDialog.Builder(view.context)

            // set title
            builder.setTitle("Alert")

            //set content area
            builder.setMessage("Are you sure you want to accept these requests ?")

            //set negative button
            builder.setPositiveButton(
                "Yes"
            ) { dialog, id ->
                // User clicked Update Now button
                val position: SparseBooleanArray = listView.checkedItemPositions
                val count = listView.count
                var item = count - 1
                while (item >= 0) {
                    if (position.get(item)) {


                        ///update accept request to database

                        ///update accept request to database
                        adapter.remove(itemlist.get(item))

                    }
                    item--
                }
                position.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText( this,"Selected requests accepted", Toast.LENGTH_SHORT).show()


            }

            //set positive button
            builder.setNegativeButton(
                "No"
            ) { dialog, id ->
                // User cancelled the dialog
            }
            builder.show()

        }


        reject.setOnClickListener {
            //Instantiate builder variable
            val view = listView
            val builder = AlertDialog.Builder(view.context)

            // set title
            builder.setTitle("Alert")

            //set content area
            builder.setMessage("Are you sure you want to reject these requests ?")

            //set negative button
            builder.setPositiveButton(
                "Yes"
            ) { dialog, id ->
                // User clicked Update Now button
                val position: SparseBooleanArray = listView.checkedItemPositions
                val count = listView.count
                var item = count - 1
                while (item >= 0) {
                    if (position.get(item))
                    {


                        ///update reject request to database

                        ///update reject request to database
                        adapter.remove(itemlist.get(item))

                    }
                    item--
                }
                position.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText( this,"Selected requests rejected", Toast.LENGTH_SHORT).show()

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