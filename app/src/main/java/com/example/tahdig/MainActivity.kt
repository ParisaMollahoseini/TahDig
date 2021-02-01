package com.example.tahdig

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent1 = Intent(this,login_signup2::class.java)
        val intent2 = Intent(this,seller_main::class.java)


        start_button.setOnClickListener {
            //val db = DatabaseHandler(signup).readableDatabase///errorrrrrrrrrrrrrrrrrrrr
            //val num = DatabaseUtils.queryNumEntries(db, "Loggedperson")
            /*if (num != 0.toLong())
            {
                startActivity(intent2)
            }
            else
            {
                startActivity(intent1)
            }*/
            startActivity(intent1)
        }
    }
}