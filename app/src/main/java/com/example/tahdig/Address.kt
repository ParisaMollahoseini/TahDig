package com.example.tahdig

class Address
{
    var id:Int =0 /////////// extra. To use as foreign key in user class
    var city:String =""
    var street:String =""
    var alley:String =""
    var number:Int =0

    constructor(city:String, street:String, alley:String, number:Int)
    {
        this.city = city
        this.street = street
        this.alley = alley
        this.number = number
    }
}