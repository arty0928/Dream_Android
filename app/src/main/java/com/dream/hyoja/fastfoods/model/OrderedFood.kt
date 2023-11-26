package com.dream.hyoja.fastfoods.model

data class OrderingFood(
    var setOption:ArrayList<String>,
    var option:ArrayList<String>,

    var food: FoodDataInterface,
    var foodCount:Int = 1,
    var totalPrice: Int = 0,
    var setMenuCount:Int = 2,


    var setDessert: setMenuDataInterface?,
    var setDrink: setMenuDataInterface?,
    var category : String

)