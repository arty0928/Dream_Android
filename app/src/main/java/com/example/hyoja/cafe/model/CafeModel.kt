package com.example.hyoja.cafe.model

object CafeModel{
    var pickOrMarket: Boolean = true // 0은 픽업 1은 매장
    var menuCategory: String = "newMenu" //카테고리 데이터
    var drinkSelected:String = ""
    lateinit var drinkSelectedList: ArrayList<String>//고른 음료 리스트
    var priceToPay:Int = 0
}