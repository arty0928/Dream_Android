package com.example.hyoja.fastfoods.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.model.OrderingFood
import com.example.hyoja.fastfoods.model.setMenuDataInterface

class FoodListViewModel : ViewModel() {
    val Tag: String = "FoodListViewModel"

    private val category = MutableLiveData<String>()
    private val foodSelected = MutableLiveData<FoodDataInterface>()
    private val foodSelectedList = MutableLiveData<ArrayList<String>>()

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

}