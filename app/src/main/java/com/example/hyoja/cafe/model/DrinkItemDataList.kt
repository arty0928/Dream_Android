package com.example.hyoja.cafe.model
import com.example.hyoja.R

interface DrinkDataInterface{
    val category: String
    val name: String
    val price: Int
    val drinkImage: Int
    val degree: Boolean
    val defaultDegree: String
}
data class Ready(
    override val category: String = "ready",
    override val name: String = "",
    override val price: Int = 0,
    override val drinkImage: Int = R.drawable.ready_sorry,
    override val degree: Boolean = false,
    override val defaultDegree: String = "selectable"
) : DrinkDataInterface
data class NewMenu1(
    override val category: String = "NewMenu",
    override val name : String = "피치히비스커스 콤부차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu1,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class NewMenu2(
    override val category: String = "NewMenu",
    override val name : String = "리치 파인 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu2,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class NewMenu3(
    override val category: String = "NewMenu",
    override val name : String = "피치 패션 콤부에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.new_menu3,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class NewMenu4(
    override val category: String = "NewMenu",
    override val name : String = "토피넛 라떼",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.new_menu4,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class NewMenu5(
    override val category: String = "NewMenu",
    override val name : String = "블랙 버블 토피넛 라떼",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.new_menu5,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class NewMenu6(
    override val category: String = "NewMenu",
    override val name : String = "토피넛 쇼콜라",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu6,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class NewMenu7(
    override val category: String = "NewMenu",
    override val name : String = "딸기 듬뿍 라떼",
    override val price : Int = 5000,
    override val drinkImage: Int = R.drawable.new_menu7,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class NewMenu8(
    override val category: String = "NewMenu",
    override val name : String = "퓨어 페퍼민트",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.new_menu8,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Coffee1(
    override val category: String = "Coffee",
    override val name : String = "디카페인 아메리카노",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.coffee_1,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Coffee2(
    override val category: String = "Coffee",
    override val name : String = "콜드브루 아메리카노",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.coffee_2,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Coffee3(
    override val category: String = "Coffee",
    override val name : String = "콜드브루 화이트 비엔나",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.coffee_3,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Coffee4(
    override val category: String = "Coffee",
    override val name : String = "콜드브루 니트로",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.coffee_4,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Coffee5(
    override val category: String = "Coffee",
    override val name : String = "콜드브루 라뗴",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.coffee_5,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Coffee6(
    override val category: String = "Coffee",
    override val name : String = "연유 카페 라떼",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.coffee_6,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Coffee7(
    override val category: String = "Coffee",
    override val name : String = "에스프레소",
    override val price : Int = 5000,
    override val drinkImage: Int = R.drawable.coffee_7,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Hot"
): DrinkDataInterface
data class Coffee8(
    override val category: String = "Coffee",
    override val name : String = "아메리카노",
    override val price : Int = 4500,
    override val drinkImage: Int = R.drawable.coffee_8,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Ade1(
    override val category: String = "Ade",
    override val name : String = "레몬 에이드",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.ade_1,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Ade2(
    override val category: String = "Ade",
    override val name : String = "자몽 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.ade_2,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Ade3(
    override val category: String = "Ade",
    override val name : String = "청포도 에이드",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.ade_3,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface

data class Beverage1(
    override val category: String = "Beverage",
    override val name : String = "생강차",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.baverage_1,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Beverage2(
    override val category: String = "Beverage",
    override val name : String = "쌍화차",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.baverage_2,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Beverage3(
    override val category: String = "Beverage",
    override val name : String = "달고나 라떼",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.baverage_3,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface

data class Flatccino1(
    override val category: String = "Flatccino",
    override val name : String = "망고 플랫치노",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.flatccino_1,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Flatccino2(
    override val category: String = "Flatccino",
    override val name : String = "꿀복숭아 플랫치노",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.flatccino_2,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Flatccino3(
    override val category: String = "Flatccino",
    override val name : String = "초콜릿 칩 플랫치노",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.flatccino_3,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Flatccino4(
    override val category: String = "Flatccino",
    override val name : String = "민트 초콜릿칩 플랫치노",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.flatccino_4,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Tea1(
    override val category: String = "Tea",
    override val name : String = "살얼음 식혜",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.tea_1,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Tea2(
    override val category: String = "Tea",
    override val name : String = "그린 루이보스",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.tea_2,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Tea3(
    override val category: String = "Tea",
    override val name : String = "샤인 히비스커스",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.tea_3,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class Tea4(
    override val category: String = "Tea",
    override val name : String = "스프링 캐모마일",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.tea_4,
    override val degree: Boolean = true,
    override val defaultDegree: String = "selectable"
): DrinkDataInterface
data class BubbleMilk1(
    override val category: String = "BubbleMilk",
    override val name : String = "버블 크림 밀크티",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.bubble_milk_1,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Shake1(
    override val category: String = "Shake",
    override val name : String = "더블 초코칩 쉐이크",
    override val price : Int = 4200,
    override val drinkImage: Int = R.drawable.shake_1,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Shake2(
    override val category: String = "Shake",
    override val name : String = "피스타치오 쉐이크",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.shake_2,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Shake3(
    override val category: String = "Shake",
    override val name : String = "오리진 쉐이크",
    override val price : Int = 4000,
    override val drinkImage: Int = R.drawable.shake_3,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface
data class Shake4(
    override val category: String = "Shake",
    override val name : String = "초코쿠키 쉐이크",
    override val price : Int = 3800,
    override val drinkImage: Int = R.drawable.shake_4,
    override val degree: Boolean = false,
    override val defaultDegree: String = "Iced"
): DrinkDataInterface