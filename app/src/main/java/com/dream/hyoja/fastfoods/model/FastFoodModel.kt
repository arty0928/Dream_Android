package com.dream.hyoja.fastfoods.model

import com.dream.hyoja.fastfoods.util.FoodAddListner

object FastFoodModel {
    var menuCategory: String = "newMenu" //카테고리 데이터
    lateinit var foodSelected: FoodDataInterface // 고른 음료
    var foodSelectedList= ArrayList<OrderingFood>()//고른 음료 리스트
    var priceToPay:Int = 0

    var setMenuCategory : String = "setDessert"
    lateinit var setMenuFoodSelected : setMenuDataInterface
    var setMenuSelectedList = ArrayList<setMenuDataInterface>()
    var payStepList = ArrayList<PayStep>()

    lateinit var currentActivity: FoodAddListner
}