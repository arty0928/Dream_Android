package com.example.hyoja.Fragments

import androidx.fragment.app.Fragment
import com.example.hyoja.databinding.FragmentSetOrOnlyBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class SetOrOnlyFragment : Fragment() {
    private val Tag: String = "SetOrOnlyFragment"
    lateinit var binding: FragmentSetOrOnlyBinding
    private lateinit var viewModel : FoodListViewModel

    private val selectedFoodItem = FastFoodModel.foodSelected
    private val setOption:ArrayList<String> = ArrayList()
    private val option:ArrayList<String> = ArrayList()

//    private val orderingFood : Order
//    private val orderingDrink: OrderingDrink = OrderingDrink(
//        degree = "hot",
//        freeOption = freeOption,
//        option = option,
//        drink = CafeModel.drinkSelected
//    )

}