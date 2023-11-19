package com.example.hyoja.cafe.model

data class OrderingDrink(
    var degree:String, //Hot or Iced
    var freeOption:ArrayList<String>,

    var option:ArrayList<String>,
    var drink:DrinkDataInterface, // 고른 음료의 데이터
    var drinkCount:Int =1,
    var size:Int = 0, // 0이 regular
    var price:Int = 0

)
