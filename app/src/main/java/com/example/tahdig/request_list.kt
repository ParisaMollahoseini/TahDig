package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup2.*
import kotlinx.android.synthetic.main.activity_request_list.*

class request_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_list)
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, itemlist)

        //check number of req
        var req_num = 0
        //check number of req
        //get list of req

        //add list of req to ui
        val context = this
        val db = DatabaseHandler(context)

        listView.adapter =  adapter
        val data = db.readDatareq()
        for (i in 0 until data.size) {

            itemlist.add("businessLicenseNumber: "+data[i].businessLicenseNumber+
                "\nowner name: "+data[i].ownerUsername+"\nphone number: "+data[i].phoneNumber
            +"\nAddress id: "+data[i].addressID)

            adapter.notifyDataSetChanged()
        }
        //add list of req to ui

    }
}