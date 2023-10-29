package com.example.hyoja.cafe.model

data class OrderingDrink(
    var degree:String,
    var freeOption:ArrayList<String>,
    var option:ArrayList<String>,
    var drink:DrinkDataInterface,
    var drinkCount:Int =1
)