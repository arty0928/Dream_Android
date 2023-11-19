package com.example.hyoja.cafe.util


// 음료주문 선택완료 콜백
interface DrinkAddListner {
    fun drinkAdded()
    fun drinkPriceSet()
}

class ApplyOrderList(listener: DrinkAddListner){
    private val listener = listener
    fun drinkAdd(){
        listener.drinkAdded()
    }

    // 리사이클러뷰에서 액티비티의 총 금액으로 보내는 콜백
    fun drinkPriceSet(){
        listener.drinkPriceSet()
    }

}