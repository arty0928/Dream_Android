package com.example.hyoja.fastfoods.util

import android.util.Log
import com.example.hyoja.fastfoods.model.NewMenu1
import com.example.hyoja.fastfoods.model.NewMenu2
import com.example.hyoja.fastfoods.model.NewMenu3
import com.example.hyoja.fastfoods.model.NewMenu4

import com.example.hyoja.cafe.model.Tea4
import com.example.hyoja.cafe.util.UtilValue
import com.example.hyoja.fastfoods.model.Dessert1
import com.example.hyoja.fastfoods.model.Dessert2
import com.example.hyoja.fastfoods.model.Dessert3
import com.example.hyoja.fastfoods.model.Dessert4
import com.example.hyoja.fastfoods.model.Dessert5
import com.example.hyoja.fastfoods.model.Dessert6
import com.example.hyoja.fastfoods.model.Dessert7
import com.example.hyoja.fastfoods.model.Dessert8
import com.example.hyoja.fastfoods.model.Dessert9
import com.example.hyoja.fastfoods.model.Drink1
import com.example.hyoja.fastfoods.model.Drink2
import com.example.hyoja.fastfoods.model.Drink3
import com.example.hyoja.fastfoods.model.Drink4
import com.example.hyoja.fastfoods.model.Drink5
import com.example.hyoja.fastfoods.model.Drink6
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.Hamburger1
import com.example.hyoja.fastfoods.model.Hamburger10
import com.example.hyoja.fastfoods.model.Hamburger11
import com.example.hyoja.fastfoods.model.Hamburger2
import com.example.hyoja.fastfoods.model.Hamburger3
import com.example.hyoja.fastfoods.model.Hamburger4
import com.example.hyoja.fastfoods.model.Hamburger5
import com.example.hyoja.fastfoods.model.Hamburger6
import com.example.hyoja.fastfoods.model.Hamburger7
import com.example.hyoja.fastfoods.model.Hamburger8
import com.example.hyoja.fastfoods.model.Hamburger9
import com.example.hyoja.fastfoods.model.Ready
import com.example.hyoja.fastfoods.model.setDessert1
import com.example.hyoja.fastfoods.model.setDessert2
import com.example.hyoja.fastfoods.model.setDessert3
import com.example.hyoja.fastfoods.model.setDessert4
import com.example.hyoja.fastfoods.model.setDessert5
import com.example.hyoja.fastfoods.model.setDessert6
import com.example.hyoja.fastfoods.model.setDessert7
import com.example.hyoja.fastfoods.model.setDessert8
import com.example.hyoja.fastfoods.model.setDessert9
import com.example.hyoja.fastfoods.model.setDrink1
import com.example.hyoja.fastfoods.model.setDrink2
import com.example.hyoja.fastfoods.model.setDrink3
import com.example.hyoja.fastfoods.model.setDrink4
import com.example.hyoja.fastfoods.model.setDrink5
import com.example.hyoja.fastfoods.model.setDrink6
import com.example.hyoja.fastfoods.model.setDrink7
import com.example.hyoja.fastfoods.model.setDrink8
import com.example.hyoja.fastfoods.model.setDrink9
import com.example.hyoja.fastfoods.model.setMenuDataInterface

class SetMenuDataFactory {
    private var setMenuArrayList: ArrayList<setMenuDataInterface> = ArrayList()
    //세트 메뉴 카테고리별 음료
    private var setDessertArrayList: ArrayList<setMenuDataInterface> = ArrayList()
    private var setDrinkArrayList: ArrayList<setMenuDataInterface> = ArrayList()


    init {
        makeSetMenuFoodList()
        seperateSetMenuCategory()
    }

    //세트 메뉴
    fun getsetDessertArrayList(): ArrayList<setMenuDataInterface>{
        return setDessertArrayList
    }

    fun getsetDrinkArrayList(): ArrayList<setMenuDataInterface>{
        return setDrinkArrayList
    }

    private fun seperateSetMenuCategory(){
        for(i in 0 until setMenuArrayList.size){
            var setItem: setMenuDataInterface = setMenuArrayList[i]
            when(setItem.category){
                "setDessert" -> setDessertArrayList.add(setItem)
                "setDrink" -> setDrinkArrayList.add(setItem)
            }
        }
    }

    private fun makeSetMenuFoodList(){
        setMenuArrayList.add(setDessert1())
        setMenuArrayList.add(setDessert2())
        setMenuArrayList.add(setDessert3())
        setMenuArrayList.add(setDessert4())
        setMenuArrayList.add(setDessert5())
        setMenuArrayList.add(setDessert6())
        setMenuArrayList.add(setDessert7())
        setMenuArrayList.add(setDessert8())
        setMenuArrayList.add(setDessert9())

        setMenuArrayList.add(setDrink1())
        setMenuArrayList.add(setDrink2())
        setMenuArrayList.add(setDrink3())
        setMenuArrayList.add(setDrink4())
        setMenuArrayList.add(setDrink5())
        setMenuArrayList.add(setDrink6())
        setMenuArrayList.add(setDrink7())
        setMenuArrayList.add(setDrink8())
        setMenuArrayList.add(setDrink9())



    }
}