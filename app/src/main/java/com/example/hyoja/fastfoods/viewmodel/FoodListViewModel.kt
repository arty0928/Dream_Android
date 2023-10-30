package com.example.hyoja.fastfoods.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface

class FoodListViewModel : ViewModel() {
    val Tag: String = "FoodListViewModel"

    private val category = MutableLiveData<String>()
    private val foodSelected = MutableLiveData<FoodDataInterface>()
    private val foodSelectedList = MutableLiveData<ArrayList<String>>()

    val categoryLiveData: LiveData<String> get() = category
    val foodSelectedLiveData: LiveData<FoodDataInterface>
        get() = foodSelected
    val foodSelectedListLiveData: LiveData<ArrayList<String>>
        get() = foodSelectedList

    init {
        category.value = "newMenu"
        foodSelected.value = null
    }

    fun categorySelectChanged(){
        category.value = FastFoodModel.menuCategory
        Log.d(Tag,"categorySelectChanged = "+category.value)
    }
    fun foodSelectChanged(){
        foodSelected.value = FastFoodModel.foodSelected
        Log.d(Tag,"drinkSelectChanged = "+foodSelected.value)
    }

}