package com.example.hyoja.cafe.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.DrinkDataInterface

class MenuListViewModel: ViewModel() {
    val Tag:String = "MenuListViewModel"

    private val category = MutableLiveData<String>()
    private val drinkSelected = MutableLiveData<DrinkDataInterface>()
    private val drinkSelectedList = MutableLiveData<ArrayList<String>>()

    val categoryLiveData: LiveData<String> get() = category
    val drinkSelectedLiveData: LiveData<DrinkDataInterface>get() = drinkSelected
    val drinkSelectedListLiveData: LiveData<ArrayList<String>>get() = drinkSelectedList

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

}
