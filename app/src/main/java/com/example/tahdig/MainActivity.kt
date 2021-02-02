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
        val intent2 = Intent(this,admin_main::class.java)
        val intent3 = Intent(this,seller_main::class.java)



        start_button.setOnClickListener {
            val context = this
            val db = DatabaseHandler(context).readableDatabase
            val num = DatabaseUtils.queryNumEntries(db, "Loggedperson")

            if (num != 0.toLong())
            {
                val query = "Select * from Loggedperson"
                val result = db.rawQuery(query, null)
                result.moveToFirst()
                val username1 = result.getString(result.getColumnIndex("username"))
                val password1 = result.getString(result.getColumnIndex("password"))
                result.close()
                if( username1.equals("admin") && password1.equals("1234"))
                    startActivity(intent2)
                else
                    startActivity(intent3)
            }
            else
            {
                startActivity(intent1)
            }

        }
    }
}