package com.example.hyoja.fastfoods.util

// 음식 주문 선택완료 콜백
interface FoodAddListner {
    fun foodAdded()
    fun foodSet()
}

class ApplyFoodOrderList(listener: FoodAddListner){
//    init {
//        var addOrder = listener
//        addOrder.foodAdded()
//    }
    private val listener = listener
    fun foodAdded(){
        listener.foodAdded()
    }
    fun foodSet(){
        listener.foodSet()
    }
}