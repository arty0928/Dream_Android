package com.example.hyoja.cafe.model

import com.example.hyoja.R

data class NewMenu1(
    val name : String = "피치히비스커스 콤부차",
    val price : Int = 4200,
    val drinkImage: Int = R.drawable.new_menu_1,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu2(
    val name : String = "리치 파인 에이드",
    val price : Int = 4000,
    val drinkImage: Int = R.drawable.new_menu_2,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu3(
    val name : String = "피치 패션 콤부에이드",
    val price : Int = 4000,
    val drinkImage: Int = R.drawable.new_menu_3,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu4(
    val name : String = "토피넛 라떼",
    val price : Int = 3800,
    val drinkImage: Int = R.drawable.new_menu_4,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu5(
    val name : String = "퓨어 페퍼민트",
    val price : Int = 4200,
    val drinkImage: Int = R.drawable.new_menu_5,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu6(
    val name : String = "블랙 버블 토피넛 라떼",
    val price : Int = 4500,
    val drinkImage: Int = R.drawable.new_menu_6,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu7(
    val name : String = "토피넛 쇼콜라",
    val price : Int = 4500,
    val drinkImage: Int = R.drawable.new_menu_7,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
data class NewMenu8(
    val name : String = "딸기 듬뿍 라떼",
    val price : Int = 4500,
    val drinkImage: Int = R.drawable.new_menu_8,
    var extra: Boolean = false,
    var degree: String = "Hot"
)
