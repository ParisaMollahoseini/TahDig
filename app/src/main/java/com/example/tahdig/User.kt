package com.example.tahdig

import kotlin.math.sign


open class User
{
    var username:String =""
    var name:String =""
    var password:String =""
    var addressID:Int =0

    constructor(){}
    constructor(username:String, name:String, password:String, addressID:Int)
    {
        this.username = username
        this.name = name
        this.password = password
        this.addressID = addressID
    }
    fun logIn(): Int {
        val db = DatabaseHandler(signup())

        val data = db.readDatauser()

        for (i in 0 until data.size) {
            if(data[i].username == this.username && data[i].password == this.password)
            {
                return 1
            }
        }
        return 0
    }
    fun logOut(){
        val db = DatabaseHandler(signup()).writableDatabase
        db.delete("Loggedperson",null,null)
    }
    fun change_info()
    {

    }
}