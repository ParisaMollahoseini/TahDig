package com.example.tahdig

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import android.content.Context

const val DATABASE_NAME = "TahDigDB"

class DatabaseHandler(var context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {

        val Loggedperson = "CREATE TABLE Loggedperson " +
                "(username VARCHAR(16) PRIMARY KEY," +
                "password VARCHAR(16))"

        db?.execSQL(Loggedperson)

        val createTableAddress = "CREATE TABLE Address " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "city VARCHAR(50)," +
                "street VARCHAR(50)," +
                "alley VARCHAR(50)," +
                "number INTEGER)"

        db?.execSQL(createTableAddress)

        val createTableUser = "CREATE TABLE User " +
                "(username VARCHAR(16) PRIMARY KEY," +
                "name VARCHAR(50)," +
                "password VARCHAR(16)," +
                "addressID INTEGER," +
                "FOREIGN KEY(addressID) REFERENCES Address(id))"

        db?.execSQL(createTableUser)

        ///////////////////added
        val createTableRestaurant = "CREATE TABLE Restaurant " +
                "(id VARCHAR(16) PRIMARY KEY," +
                "menu VARCHAR(100)," +
                "addressID INTEGER," +
                "FOREIGN KEY(addressID) REFERENCES Address(id))"

        db?.execSQL(createTableRestaurant)


        val createTableNewRequests = "CREATE TABLE NewRequests " +
                "(id VARCHAR(16) PRIMARY KEY," +
                "menu VARCHAR(100)," +
                "addressID INTEGER," +
                "FOREIGN KEY(addressID) REFERENCES Address(id))"

        db?.execSQL(createTableNewRequests)
        ///////////////////////

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun cleartables()
    {
        val db = this.writableDatabase
        db.delete("Address",null,null)
        db.delete("User",null,null)
        db.delete("Loggedperson",null,null)
        db.execSQL("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='Address';")
    }


    fun insertAddress(city:String,street:String,alley:String,
    number:Int): Long {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("city", city)
        cv.put("street", street)
        cv.put("alley", alley)
        cv.put("number", number)

        var result = db.insert("Address", null, cv)

        if (result ==-1.toLong())
            Toast.makeText(context, "Address insertion failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Address successfully inserted", Toast.LENGTH_SHORT).show()
        return result
    }

    fun insertUser(username:String,name:String,password:String,addressID:Int): Long {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("username", username)
        cv.put("name", name)
        cv.put("password", password)
        cv.put("addressID", addressID)

        var result = db.insert("User", null, cv)

        if (result ==-1.toLong())
            Toast.makeText(context, "user insertion failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "user successfully inserted", Toast.LENGTH_SHORT).show()
        return result
    }

    fun readDatauser(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from User"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User()
                user.username = result.getString(result.getColumnIndex("username"))
                user.name = result.getString(result.getColumnIndex("name"))
                user.password = result.getString(result.getColumnIndex("password"))
                user.addressID = result.getString(result.getColumnIndex("addressID")).toInt()
                list.add(user)
            }
            while (result.moveToNext())
        }
        return list
    }

    fun insertLoggedperson(username:String,password:String){
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("username", username)
        cv.put("password", password)


        var result = db.insert("Loggedperson", null, cv)
    }
    fun deletefromLoggedperson(){
        val db = this.writableDatabase
        db.delete("Loggedperson",null,null)
    }
}

class User {
    var username : String = ""
    var password : String = ""
    var name : String = ""
    var addressID : Int = 0
}


