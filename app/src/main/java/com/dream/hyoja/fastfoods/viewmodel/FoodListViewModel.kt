package com.dream.hyoja.fastfoods.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.FoodDataInterface
import com.dream.hyoja.fastfoods.model.OrderingFood
import com.dream.hyoja.fastfoods.model.setMenuDataInterface

class FoodListViewModel : ViewModel() {
    val Tag: String = "FoodListViewModel"

    val category = MutableLiveData<String>()
    private val foodSelected = MutableLiveData<FoodDataInterface>()
    private val foodSelectedList = MutableLiveData<ArrayList<String>>()

    private val orderFoodList = MutableLiveData<String>()

    private val setMenuCategory = MutableLiveData<String>()
    private val setMenuSelected = MutableLiveData<setMenuDataInterface>()
    private val setMenuSelectedList = MutableLiveData<ArrayList<String>>()
    private val orderingFood = MutableLiveData<OrderingFood>()

    val categoryLiveData: LiveData<String> get() = category

    val setMenuCategoryLiveData : LiveData<String> get() = setMenuCategory

    val orderingFoodLiveData : LiveData<OrderingFood> get() = orderingFood
    val foodSelectedLiveData: LiveData<FoodDataInterface>
        get() = foodSelected
    val foodSelectedListLiveData: LiveData<ArrayList<String>>
        get() = foodSelectedList

    val setMenuSelectedLiveData : LiveData<setMenuDataInterface> get() = setMenuSelected
    val setMenuSelectedListLiveData : LiveData<ArrayList<String>> get() = setMenuSelectedList

    init {
        category.value = "newMenu"
        foodSelected.value = null
        setMenuCategory.value = "setDessert"
        setMenuSelected.value = null
    }

    fun categorySelectChanged(){
        category.value = FastFoodModel.menuCategory
        Log.d(Tag,"categorySelectChanged = "+category.value)
    }
    fun foodSelectChanged(){
        foodSelected.value = FastFoodModel.foodSelected
        Log.d(Tag,"drinkSelectChanged = "+foodSelected.value)
    }

    fun setMenuCategorySelectChanged(){
        setMenuCategory.value = FastFoodModel.setMenuCategory
        Log.d(Tag,"setMenuCategorySelectedChanged = "+setMenuCategory.value)
    }

    fun setMenuSelectChanged(){
        setMenuSelected.value = FastFoodModel.setMenuFoodSelected
        Log.d(Tag,"setMenuSelectChanged = "+setMenuSelected.value)
    }

    fun orderListChanged(){
        orderFoodList.value = FastFoodModel.foodSelectedList.size.toString()
        Log.d(Tag,"foodSelectedChanged ="+orderFoodList.value)
    }

    fun orderListUpdateCount(position: Int, newList: ArrayList<OrderingFood>){
        FastFoodModel.foodSelectedList[position] = newList[position]
        orderFoodList.value = FastFoodModel.foodSelectedList.size.toString()
        Log.d(Tag,"foodSelectedChanged ="+orderFoodList.value)
    }
}