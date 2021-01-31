package com.example.tahdig

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


const val DATABASE_NAME = "TahDigDB"

class DatabaseHandler(var context:signup) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1)
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


        //////////////other tables here
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {}
    fun cleartables()
    {
        val db = this.writableDatabase
        db.delete("Address",null,null)
        db.delete("User",null,null)
        db.execSQL("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='Address';")

    }
    fun insertAddress(adr: Address): Long {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("city", adr.city)
        cv.put("street", adr.street)
        cv.put("alley", adr.alley)
        cv.put("number", adr.number)

        var result = db.insert("Address", null, cv)
        adr.id = result.toInt()
        if (result ==-1.toLong())
            Toast.makeText(context, "Address insertion failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Address successfully inserted", Toast.LENGTH_SHORT).show()
        return result

    }
    fun insertUser(usr: User): Long {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("username", usr.username)
        cv.put("name", usr.name)
        cv.put("password", usr.password)
        cv.put("addressID", usr.addressID)

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
}