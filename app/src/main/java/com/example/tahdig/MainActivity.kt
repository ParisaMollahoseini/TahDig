package com.example.tahdig

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent1 = Intent(this,login_signup2::class.java)
        val intent2 = Intent(this,AdminMainActivity::class.java)


        start_button.setOnClickListener {
            val context = this
            val db = DatabaseHandler(context).readableDatabase
            val num = DatabaseUtils.queryNumEntries(db, "Loggedperson")

            if (num != 0.toLong())
            {
                startActivity(intent2)
            }
            else
            {
                startActivity(intent1)
            }

        }
    }
}