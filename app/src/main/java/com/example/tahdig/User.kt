package com.example.tahdig

open class User
{
    var username:Int =0
    var name:String =""
    var password:String =""
    var addressID:Int =0

    constructor(username:Int, name:String, password:String, addressID:Int)
    {
        this.username = username
        this.name = name
        this.password = password
        this.addressID = addressID
    }
}