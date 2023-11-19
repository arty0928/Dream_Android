package com.example.hyoja.fastfoods.model

import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.cafe.util.DrinkAddListner
import com.example.hyoja.fastfoods.util.FoodAddListner
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

object FastFoodModel {
    var menuCategory: String = "newMenu" //카테고리 데이터
    lateinit var foodSelected: FoodDataInterface // 고른 음료
    var foodSelectedList= ArrayList<OrderingFood>()//고른 음료 리스트
    var priceToPay:Int = 0

    var setMenuCategory : String = "setDessert"
    lateinit var setMenuFoodSelected : setMenuDataInterface
    var setMenuSelectedList = ArrayList<setMenuDataInterface>()

    lateinit var currentActivity: FoodAddListner
}