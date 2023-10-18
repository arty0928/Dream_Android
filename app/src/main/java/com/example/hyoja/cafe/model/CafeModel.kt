package com.example.hyoja.cafe.model

object CafeModel{
    var pickOrMarket: Boolean = true // 0은 픽업 1은 매장
    var menuCategory: String = "newMenu" //카테고리 데이터
    lateinit var drinkSelected:DrinkDataInterface // 고른 음료
    var drinkSelectedList= ArrayList<OrderedDrink>()//고른 음료 리스트
    var priceToPay:Int = 0
}