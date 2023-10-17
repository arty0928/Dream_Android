package com.example.hyoja.cafe.util

import com.example.hyoja.cafe.model.Ade1
import com.example.hyoja.cafe.model.Ade2
import com.example.hyoja.cafe.model.Ade3
import com.example.hyoja.cafe.model.Beverage1
import com.example.hyoja.cafe.model.Beverage2
import com.example.hyoja.cafe.model.Beverage3
import com.example.hyoja.cafe.model.BubbleMilk1
import com.example.hyoja.cafe.model.Coffee1
import com.example.hyoja.cafe.model.Coffee2
import com.example.hyoja.cafe.model.Coffee3
import com.example.hyoja.cafe.model.Coffee4
import com.example.hyoja.cafe.model.Coffee5
import com.example.hyoja.cafe.model.Coffee6
import com.example.hyoja.cafe.model.Coffee7
import com.example.hyoja.cafe.model.Coffee8
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.model.Flatccino1
import com.example.hyoja.cafe.model.Flatccino2
import com.example.hyoja.cafe.model.Flatccino3
import com.example.hyoja.cafe.model.Flatccino4
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.model.NewMenu5
import com.example.hyoja.cafe.model.NewMenu6
import com.example.hyoja.cafe.model.NewMenu7
import com.example.hyoja.cafe.model.NewMenu8
import com.example.hyoja.cafe.model.Ready
import com.example.hyoja.cafe.model.Shake1
import com.example.hyoja.cafe.model.Shake2
import com.example.hyoja.cafe.model.Shake3
import com.example.hyoja.cafe.model.Shake4
import com.example.hyoja.cafe.model.Tea1
import com.example.hyoja.cafe.model.Tea2
import com.example.hyoja.cafe.model.Tea3
import com.example.hyoja.cafe.model.Tea4
import com.example.hyoja.cafe.util.UtilValue

class DrinkDataFactory{
    // 모든 음료
    private var drinkArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    // 카테고리별 음료
    private var newMenuArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var coffeeArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var teaArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var beverageArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var shakeArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var flatccinoArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var bubbleMilkArrayList: ArrayList<DrinkDataInterface> = ArrayList()
    private var adeArrayList: ArrayList<DrinkDataInterface> = ArrayList()

    init {
        makeDrinkList()
        seperateCategory()
        fillCategory()
    }
    fun getDrinkArrayList(): ArrayList<DrinkDataInterface>{
        return drinkArrayList
    }
    fun getNewMenuArrayList(): ArrayList<DrinkDataInterface>{
        return newMenuArrayList
    }
    fun getCoffeeArrayList(): ArrayList<DrinkDataInterface>{
        return coffeeArrayList
    }
    fun getTeaArrayList(): ArrayList<DrinkDataInterface>{
        return teaArrayList
    }
    fun getShakeArrayList(): ArrayList<DrinkDataInterface>{
        return shakeArrayList
    }
    fun getBeverageArrayList(): ArrayList<DrinkDataInterface>{
        return beverageArrayList
    }
    fun getAdeArrayList(): ArrayList<DrinkDataInterface>{
        return adeArrayList
    }
    fun getFlatccinoArrayList(): ArrayList<DrinkDataInterface>{
        return flatccinoArrayList
    }
    fun getBubbleMilkArrayList(): ArrayList<DrinkDataInterface>{
        return bubbleMilkArrayList
    }


    //카테고리별로 나누기
    private fun seperateCategory(){
        for(i in 0 until drinkArrayList.size){
            var drinkItem: DrinkDataInterface = drinkArrayList[i]
            when(drinkItem.category){
                "NewMenu" -> newMenuArrayList.add(drinkItem)
                "Coffee" -> coffeeArrayList.add(drinkItem)
                "Tea" -> teaArrayList.add(drinkItem)
                "Shake" -> shakeArrayList.add(drinkItem)
                "Ade" -> adeArrayList.add(drinkItem)
                "Flatccino" -> flatccinoArrayList.add(drinkItem)
                "Beverage" -> beverageArrayList.add(drinkItem)
                "BubbleMilk" -> bubbleMilkArrayList.add(drinkItem)
            }
        }

    }

    //데이터가 없는 공간은 그만큼 ready로 채워준다.
    private fun fillCategory(){
        val value: UtilValue = UtilValue()

        if(newMenuArrayList.size<value.newMenuListSize){
            while (drinkArrayList.size<=value.newMenuListSize){
                drinkArrayList.add(Ready())
            }
        }
        if(coffeeArrayList.size<value.coffeeListSize){
            while (coffeeArrayList.size<=value.newMenuListSize){
                coffeeArrayList.add(Ready())
            }
        }
        if(shakeArrayList.size<value.shakeListSize){
            while (shakeArrayList.size<=value.newMenuListSize){
                shakeArrayList.add(Ready())
            }
        }
        if(beverageArrayList.size<value.beverageListSize){
            while (beverageArrayList.size<=value.newMenuListSize){
                beverageArrayList.add(Ready())
            }
        }
        if(bubbleMilkArrayList.size<value.bubbleMilkSize){
            while (bubbleMilkArrayList.size<=value.newMenuListSize){
                bubbleMilkArrayList.add(Ready())
            }
        }
        if(adeArrayList.size<value.adeListSize){
            while (adeArrayList.size<=value.newMenuListSize){
                adeArrayList.add(Ready())
            }
        }
        if(flatccinoArrayList.size<value.flatccinoListSize){
            while (flatccinoArrayList.size<=value.newMenuListSize){
                flatccinoArrayList.add(Ready())
            }
        }
        if(teaArrayList.size<value.teaListSize){
            while (teaArrayList.size<=value.newMenuListSize){
                teaArrayList.add(Ready())
            }
        }
    }


    //ArrayList에 음료데이터 모두 넣기
    //음료 추가할때 여기도 봐줘야 함
    private fun makeDrinkList(){
        drinkArrayList.add(NewMenu1())
        drinkArrayList.add(NewMenu2())
        drinkArrayList.add(NewMenu3())
        drinkArrayList.add(NewMenu4())
        drinkArrayList.add(NewMenu5())
        drinkArrayList.add(NewMenu6())
        drinkArrayList.add(NewMenu7())
        drinkArrayList.add(NewMenu8())
        drinkArrayList.add(Coffee1())
        drinkArrayList.add(Coffee2())
        drinkArrayList.add(Coffee3())
        drinkArrayList.add(Coffee4())
        drinkArrayList.add(Coffee5())
        drinkArrayList.add(Coffee6())
        drinkArrayList.add(Coffee7())
        drinkArrayList.add(Coffee8())
        drinkArrayList.add(Flatccino1())
        drinkArrayList.add(Flatccino2())
        drinkArrayList.add(Flatccino3())
        drinkArrayList.add(Flatccino4())
        drinkArrayList.add(Tea1())
        drinkArrayList.add(Tea2())
        drinkArrayList.add(Tea3())
        drinkArrayList.add(Tea4())
        drinkArrayList.add(Shake1())
        drinkArrayList.add(Shake2())
        drinkArrayList.add(Shake3())
        drinkArrayList.add(Shake4())
        drinkArrayList.add(Beverage1())
        drinkArrayList.add(Beverage2())
        drinkArrayList.add(Beverage3())
        drinkArrayList.add(Ade1())
        drinkArrayList.add(Ade2())
        drinkArrayList.add(Ade3())
        drinkArrayList.add(BubbleMilk1())
    }
}
