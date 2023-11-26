package com.dream.hyoja.fastfoods.util

import com.dream.hyoja.fastfoods.model.setDessert1
import com.dream.hyoja.fastfoods.model.setDessert2
import com.dream.hyoja.fastfoods.model.setDessert3
import com.dream.hyoja.fastfoods.model.setDessert4
import com.dream.hyoja.fastfoods.model.setDessert5
import com.dream.hyoja.fastfoods.model.setDessert6
import com.dream.hyoja.fastfoods.model.setDessert7
import com.dream.hyoja.fastfoods.model.setDessert8
import com.dream.hyoja.fastfoods.model.setDessert9
import com.dream.hyoja.fastfoods.model.setDrink1
import com.dream.hyoja.fastfoods.model.setDrink2
import com.dream.hyoja.fastfoods.model.setDrink3
import com.dream.hyoja.fastfoods.model.setDrink4
import com.dream.hyoja.fastfoods.model.setDrink5
import com.dream.hyoja.fastfoods.model.setDrink6
import com.dream.hyoja.fastfoods.model.setDrink7
import com.dream.hyoja.fastfoods.model.setDrink8
import com.dream.hyoja.fastfoods.model.setDrink9
import com.dream.hyoja.fastfoods.model.setMenuDataInterface

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