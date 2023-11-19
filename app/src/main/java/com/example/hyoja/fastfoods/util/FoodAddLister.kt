package com.example.hyoja.fastfoods.util

// 음식 주문 선택완료 콜백
interface FoodAddListner {
    fun foodAdded()
}

class ApplyFoodOrderList(listener: FoodAddListner){
    init {
        var addOrder = listener
        addOrder.foodAdded()
    }
}