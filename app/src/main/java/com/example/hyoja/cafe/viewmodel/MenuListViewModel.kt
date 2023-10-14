package com.example.hyoja.cafe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.cafe.model.CafeModel

class MenuListViewModel: ViewModel() {
    private val category = MutableLiveData<String>()
    private val drink = MutableLiveData<String>()

    val categoryLiveData: LiveData<String> get() = category
    val drinkLiveData: LiveData<String> get() = drink

    init {
        category.value = "newMenu"
        drink.value = ""
    }

    fun categorySelectChanged(){
        category.value = CafeModel.menuCategory
    }

}
