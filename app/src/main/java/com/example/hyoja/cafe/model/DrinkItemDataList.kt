package com.example.hyoja.cafe.model

import com.example.hyoja.R

interface DrinkDataInterface{
    val name: String
    val price: Int
    val drinkImage: Int
    val degree: Boolean
}
data class Ready(
    override val name: String = "준비중입니다",
    override val price: Int = 0,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = false
) : DrinkDataInterface

data class NewMenu1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu5(
    override val name : String = "퓨어 페퍼민트",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_5,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu6(
    override val name : String = "블랙 버블 토피넛 라떼",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu_6,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu7(
    override val name : String = "토피넛 쇼콜라",
    override val price : Int = 5000,
    override val drinkImage: Int = R.drawable.new_menu_7,
    override val degree: Boolean = true
): DrinkDataInterface
data class NewMenu8(
    override val name : String = "딸기 듬뿍 라떼",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu_8,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee5(
    override val name : String = "퓨어 페퍼민트",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_5,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee6(
    override val name : String = "블랙 버블 토피넛 라떼",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu_6,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee7(
    override val name : String = "토피넛 쇼콜라",
    override val price : Int = 5000,
    override val drinkImage: Int = R.drawable.new_menu_7,
    override val degree: Boolean = true
): DrinkDataInterface
data class Coffee8(
    override val name : String = "딸기 듬뿍 라떼",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu_8,
    override val degree: Boolean = true
): DrinkDataInterface
data class Ade1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Ade2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Ade3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Ade4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class Beverage1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Beverage2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Beverage3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Beverage4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class Flatccino1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Flatccino2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Flatccino3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Flatccino4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class Tea1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Tea2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Tea3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Tea4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class BubbleMilk1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class BubbleMilk2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class BubbleMilk3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class BubbleMilk4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface
data class Shake1(
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu_1,
    override val degree: Boolean = true
): DrinkDataInterface
data class Shake2(
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_2,
    override val degree: Boolean = true
): DrinkDataInterface
data class Shake3(
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu_3,
    override val degree: Boolean = true
): DrinkDataInterface
data class Shake4(
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu_4,
    override val degree: Boolean = true
): DrinkDataInterface