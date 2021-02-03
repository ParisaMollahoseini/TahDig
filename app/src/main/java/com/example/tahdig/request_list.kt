package com.example.tahdig

import android.app.AlertDialog
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_main.*
import kotlinx.android.synthetic.main.activity_login_signup2.*
import kotlinx.android.synthetic.main.activity_request_list.*
import java.sql.SQLException

class request_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_list)

        val intent1 = Intent(this,admin_main::class.java)

        val intent1_3 = intent

        val map_data :HashMap<String,String> = intent1_3.getSerializableExtra("data_array") as HashMap<String, String>


        reqtitle_toolbar.setNavigationOnClickListener(View.OnClickListener() {
            intent1.putExtra("data_array",map_data)
            startActivity(intent1)
        });

        var itemlist = arrayListOf<String>()
        var adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, itemlist)

        val context = this
        val db = DatabaseHandler(context)

        //get list of req
        val db1  = db.readableDatabase
        val num = DatabaseUtils.queryNumEntries(db1, "NewRequests")

        if (num != 0.toLong()) {

            //add list of req to ui
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
        }
//
//        else {
//
//            //there is no request
//        }
//
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

                        //update accept request to database
                        val data = db.readDatareq()
                        for (j in 0 until data.size) {
                            db.insertRestaurant(data[j].restaurant_name, data[j].ownerUsername,
                                data[j].businessLicenseNumber,data[j].phoneNumber,data[j].addressID)
                        }
                            db.DeleteFromNewRequests()
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
                        db.DeleteFromNewRequests()
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