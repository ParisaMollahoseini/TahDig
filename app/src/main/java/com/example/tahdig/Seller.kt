package com.example.tahdig

class Seller : User
{
    var restaurantID:Int =0

    constructor(username:Int, name:String, password:String, addressID:Int) : super (username, name, password, addressID)

    fun addRestaurant(res_id:Int)
    {
        this.restaurantID = res_id
    }
}