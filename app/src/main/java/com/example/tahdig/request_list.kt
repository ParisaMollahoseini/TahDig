package com.example.tahdig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_signup2.*

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

        val data = db.readDatareq()
//        for (i in 0 until data.size) {
//
//            if(data[i].username.equals(Username.text.toString()) && data[i].password.equals(Password.text.toString()))
//            {
//                flag = 1
//                Toast.makeText( this,"You are logged in successfully...", Toast.LENGTH_SHORT).show()
//                db.insertLoggedperson(Username.toString(),Password.toString())
//                startActivity(intent3)
//            }
//        }
        //add list of req to ui

    }
}