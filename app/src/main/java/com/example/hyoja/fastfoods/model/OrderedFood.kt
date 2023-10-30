package com.example.hyoja.fastfoods.model

import com.example.hyoja.cafe.model.DrinkDataInterface

data class OrderingDrink(
    var setOption:ArrayList<String>,
    var option:ArrayList<String>,
    var food: FoodDataInterface,
    var foodCount:Int =1,
    var price: Int = 0
)

