package com.example.hyoja.cafe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hyoja.cafe.model.CafeModel

class MenuListViewModel: ViewModel() {
    private val category = MutableLiveData<String>()
    val categoryLiveData: LiveData<String> get() = category

    init {
        category.value = ""
    }

    fun dataChanged(){
        category.value = CafeModel.menuCategory
    }
}
