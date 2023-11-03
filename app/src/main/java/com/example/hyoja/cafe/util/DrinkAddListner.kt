package com.example.hyoja.cafe.util


// 음료주문 선택완료 콜백
interface DrinkAddListner {
    fun drinkAdded()
}

class ApplyOrderList(listener: DrinkAddListner){
    init {
        var addOrder = listener
        addOrder.drinkAdded()
    }
}