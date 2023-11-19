package com.example.hyoja.cafe.model

import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.cafe.util.DrinkAddListner

object CafeModel{
    var pickOrMarket: Boolean = true // 0은 픽업 1은 매장
    var menuCategory: String = "newMenu" // 카테고리 데이터
    lateinit var drinkSelected:DrinkDataInterface // 고른 음료
    var drinkSelectedList= ArrayList<OrderingDrink>() // 장바구니에 담은 음료 리스트
    var priceToPay:Int = getTotalPrice()
    var optionTemp:ArrayList<String> = ArrayList()

    lateinit var currentActivity: DrinkAddListner

    fun getTotalPrice(): Int{
        var price = 0
        for (i in 0 until CafeModel.drinkSelectedList.size){
            price += drinkSelectedList[i].price
        }
        return price
    }
}