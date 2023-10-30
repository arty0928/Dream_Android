package com.example.hyoja.fastfoods.model
import com.example.hyoja.R

interface FoodDataInterface{
    val category: String
    val name: String
    val price: Int
    val foodImage: Int
    val set: Boolean
}

data class Ready(
    override val category: String = "ready",
    override val name: String = "",
    override val price: Int = 0,
    override val foodImage: Int = R.drawable.ready_sorry,
    override val set: Boolean = false
) : FoodDataInterface

data class NewMenu1(
    override val category: String = "NewMenu",
    override val name : String = "더블불고기버거",
    override val price : Int = 4400,
    override val foodImage: Int = R.drawable.burger1,
    override val set: Boolean = true
): FoodDataInterface

data class NewMenu2(
    override val category: String = "NewMenu",
    override val name : String = "피쉬버거",
    override val price : Int = 3500,
    override val foodImage: Int = R.drawable.burger2,
    override val set: Boolean = true
): FoodDataInterface

data class NewMenu3(
    override val category: String = "NewMenu",
    override val name : String = "새우버거",
    override val price : Int = 4500,
    override val foodImage: Int = R.drawable.burger3,
    override val set: Boolean = true
): FoodDataInterface

data class NewMenu4(
    override val category: String = "NewMenu",
    override val name : String = "치킨버거",
    override val price : Int = 4600,
    override val foodImage: Int = R.drawable.burger4,
    override val set: Boolean = true
): FoodDataInterface

data class NewMenu5(
    override val category: String = "NewMenu",
    override val name : String = "더블치킨버거",
    override val price : Int = 5500,
    override val foodImage: Int = R.drawable.burger5,
    override val set: Boolean = true
): FoodDataInterface

data class NewMenu6(
    override val category: String = "NewMenu",
    override val name : String = "한우불고기버거",
    override val price : Int = 4400,
    override val foodImage: Int = R.drawable.burger6,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger1(
    override val category: String = "Hamburger",
    override val name : String = "더블불고기버거",
    override val price : Int = 4400,
    override val foodImage: Int = R.drawable.burger1,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger2(
    override val category: String = "Hamburger",
    override val name : String = "피쉬버거",
    override val price : Int = 3500,
    override val foodImage: Int = R.drawable.burger2,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger3(
    override val category: String = "Hamburger",
    override val name : String = "새우버거",
    override val price : Int = 4500,
    override val foodImage: Int = R.drawable.burger3,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger4(
    override val category: String = "Hamburger",
    override val name : String = "치킨버거",
    override val price : Int = 4600,
    override val foodImage: Int = R.drawable.burger4,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger5(
    override val category: String = "Hamburger",
    override val name : String = "더블치킨버거",
    override val price : Int = 5500,
    override val foodImage: Int = R.drawable.burger5,
    override val set: Boolean = true
): FoodDataInterface

data class Hamburger6(
    override val category: String = "Hamburger",
    override val name : String = "한우불고기버거",
    override val price : Int = 4400,
    override val foodImage: Int = R.drawable.burger6,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert1(
    override val category: String = "Dessert",
    override val name : String = "포테이토",
    override val price : Int = 1800,
    override val foodImage: Int = R.drawable.dessert1,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert2(
    override val category: String = "Dessert",
    override val name : String = "양념감자",
    override val price : Int = 2300,
    override val foodImage: Int = R.drawable.dessert2,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert3(
    override val category: String = "Dessert",
    override val name : String = "웨지포테이토",
    override val price : Int = 2100,
    override val foodImage: Int = R.drawable.dessert3,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert4(
    override val category: String = "Dessert",
    override val name : String = "치즈스틱",
    override val price : Int = 2400,
    override val foodImage: Int = R.drawable.dessert4,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert5(
    override val category: String = "Dessert",
    override val name : String = "통오징어링",
    override val price : Int = 2600,
    override val foodImage: Int = R.drawable.dessert5,
    override val set: Boolean = true
): FoodDataInterface

data class Dessert6(
    override val category: String = "Dessert",
    override val name : String = "모짜크림치즈볼",
    override val price : Int = 2300,
    override val foodImage: Int = R.drawable.dessert6,
    override val set: Boolean = true
): FoodDataInterface

data class Drink1(
    override val category: String = "Drink",
    override val name : String = "콜라",
    override val price : Int = 2000,
    override val foodImage: Int = R.drawable.drink1,
    override val set: Boolean = true
): FoodDataInterface

data class Drink2(
    override val category: String = "Drink",
    override val name : String = "사이다",
    override val price : Int = 2000,
    override val foodImage: Int = R.drawable.drink2,
    override val set: Boolean = true
): FoodDataInterface

data class Drink3(
    override val category: String = "Drink",
    override val name : String = "제로슈가콜라",
    override val price : Int = 2000,
    override val foodImage: Int = R.drawable.drink3,
    override val set: Boolean = true
): FoodDataInterface

data class Drink4(
    override val category: String = "Drink",
    override val name : String = "아메리카노",
    override val price : Int = 2500,
    override val foodImage: Int = R.drawable.drink4,
    override val set: Boolean = true
): FoodDataInterface

data class Drink5(
    override val category: String = "Drink",
    override val name : String = "아이스 아메리카노",
    override val price : Int = 2500,
    override val foodImage: Int = R.drawable.drink5,
    override val set: Boolean = true
): FoodDataInterface

data class Drink6(
    override val category: String = "Drink",
    override val name : String = "아이스티",
    override val price : Int = 2300,
    override val foodImage: Int = R.drawable.drink6,
    override val set: Boolean = true
): FoodDataInterface



