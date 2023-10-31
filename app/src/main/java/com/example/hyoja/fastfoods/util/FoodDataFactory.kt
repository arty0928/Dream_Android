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

class FoodDataFactory {
    // 모든 음료
    private var foodArrayList: ArrayList<FoodDataInterface> = ArrayList()
    // 카테고리별 음료
    private var newMenuArrayList: ArrayList<FoodDataInterface> = ArrayList()
    private var hamburgerArrayList: ArrayList<FoodDataInterface> = ArrayList()
    private var dessertArrayList: ArrayList<FoodDataInterface> = ArrayList()
    private var drinkArrayList: ArrayList<FoodDataInterface> = ArrayList()

    init {
        makeFoodList()
        seperateCategory()
        fillCategory()
    }

    fun getNewMenuArrayList(): ArrayList<FoodDataInterface>{
        return newMenuArrayList
    }

    fun getHamburgerArrayList(): ArrayList<FoodDataInterface>{
        return hamburgerArrayList
    }

    fun getDessertArrayList(): ArrayList<FoodDataInterface>{
        return dessertArrayList
    }

    fun getDrinkArrayList(): ArrayList<FoodDataInterface>{
        return drinkArrayList
    }

    //카테고리별로 나누기
    private fun seperateCategory(){
        for(i in 0 until foodArrayList.size){
            var foodItem: FoodDataInterface = foodArrayList[i]
            when(foodItem.category){
                "NewMenu" -> newMenuArrayList.add(foodItem)
                "Hamburger" -> hamburgerArrayList.add(foodItem)
                "Dessert" -> dessertArrayList.add(foodItem)
                "Drink" -> drinkArrayList.add(foodItem)
            }
        }
    }

    //데이터가 없는 공간은 그만큼 ready로 채워준다.
    private fun fillCategory(){
        val value = FoodUtilValue()

        Log.d("fill_____","${newMenuArrayList.size}//${dessertArrayList.size}")

        if(newMenuArrayList.size < value.newMenuListSize){
            while (newMenuArrayList.size<value.newMenuListSize){
                newMenuArrayList.add(Ready())
            }
        }
        Log.d("fill1111111111","${newMenuArrayList.size}//${dessertArrayList.size}")

        if(hamburgerArrayList.size < value.hamburgerListSize){
            while (hamburgerArrayList.size < value.newMenuListSize){
                hamburgerArrayList.add(Ready())
            }
        }
        Log.d("fill2222222222","${hamburgerArrayList.size}//${dessertArrayList.size}")

        if(dessertArrayList.size < value.dessertListSize){
            while (dessertArrayList.size < value.newMenuListSize){
                dessertArrayList.add(Ready())
            }
        }
        Log.d("fill333333333","${dessertArrayList.size}//${dessertArrayList.size}")

        if(drinkArrayList.size < value.drinkListSize){
            while (drinkArrayList.size < value.newMenuListSize){
                drinkArrayList.add(Ready())
            }
        }
        Log.d("fill!!!!!!","${foodArrayList.size}//${dessertArrayList.size}")

    }

    //ArrayList에 음료데이터 모두 넣기
    //음료 추가할때 여기도 봐줘야 함
    private fun makeFoodList(){
        foodArrayList.add(NewMenu1())
        foodArrayList.add(NewMenu2())
        foodArrayList.add(NewMenu3())
        foodArrayList.add(NewMenu4())

        foodArrayList.add(Hamburger1())
        foodArrayList.add(Hamburger2())
        foodArrayList.add(Hamburger3())
        foodArrayList.add(Hamburger4())
        foodArrayList.add(Hamburger5())
        foodArrayList.add(Hamburger6())
        foodArrayList.add(Hamburger7())
        foodArrayList.add(Hamburger8())
        foodArrayList.add(Hamburger9())
        foodArrayList.add(Hamburger10())
        foodArrayList.add(Hamburger11())


        foodArrayList.add(Dessert1())
        foodArrayList.add(Dessert2())
        foodArrayList.add(Dessert3())
        foodArrayList.add(Dessert4())
        foodArrayList.add(Dessert5())
        foodArrayList.add(Dessert6())

        foodArrayList.add(Drink1())
        foodArrayList.add(Drink2())
        foodArrayList.add(Drink3())
        foodArrayList.add(Drink4())
        foodArrayList.add(Drink5())
        foodArrayList.add(Drink6())
    }
}