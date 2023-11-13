package com.example.hyoja.fastfoods.model

data class OrderingFood(
    var setOption:ArrayList<String>,
    var option:ArrayList<String>,

    var food: FoodDataInterface,
    var foodCount:Int = 1,
    var price: Int = 0,
    var setMenuCount:Int = 2,


    var setDessert: setMenuDataInterface?,
    var setDrink: setMenuDataInterface?,

    )

