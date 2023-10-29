package com.example.hyoja.cafe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.model.OrderingDrink

class MenuListViewModel: ViewModel() {
    val Tag:String = "MenuListViewModel"

    private val category = MutableLiveData<String>()
    private val drinkSelected = MutableLiveData<DrinkDataInterface>()
    private val orderList = MutableLiveData<String>()
    val categoryLiveData: LiveData<String> get() = category
    val drinkSelectedLiveData: LiveData<DrinkDataInterface> get() = drinkSelected
    val orderListLiveData: LiveData<String> get() = orderList

    init {
        category.value = "newMenu"
        drinkSelected.value = null
    }

    fun categorySelectChanged(){
        category.value = CafeModel.menuCategory
        Log.d(Tag,"categorySelectChanged = "+category.value)
    }
    fun drinkSelectChanged(){
        drinkSelected.value = CafeModel.drinkSelected
        Log.d(Tag,"drinkSelectChanged = "+drinkSelected.value)
    }

    fun orderListChanged(){
        orderList.value = CafeModel.drinkSelectedList.size.toString()
        Log.d(Tag,"orderListChanged = "+ orderList.value)
    }
}
