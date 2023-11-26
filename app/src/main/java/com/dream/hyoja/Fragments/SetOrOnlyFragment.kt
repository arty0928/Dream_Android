package com.dream.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.databinding.FragmentSetOrOnlyBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.OrderingFood
import com.dream.hyoja.fastfoods.util.ApplyFoodOrderList
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class SetOrOnlyFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentSetOrOnlyBinding
    lateinit var viewModel: FoodListViewModel

    private val option :ArrayList<String> =ArrayList()

    private val setOption :ArrayList<String> =ArrayList()
    private val category : String = "newMenu"

    val orderingFood : OrderingFood = OrderingFood(
        food = FastFoodModel.foodSelected,
        option = option,
        setOption = setOption,
        setDessert = null,
        setDrink = null,
        category = category
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentSetOrOnlyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        binding.dialogXButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.optionOnlyBurger.setOnClickListener {
            addOnlyBurger()

            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()

            ApplyFoodOrderList(FastFoodModel.currentActivity).foodAdded()

        }

        binding.optionSetBurger.setOnClickListener {
            // 현재 Fragment를 닫기
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()

            // ChoiceSetMenuDialogFragment 보여주기
            ChoiceSetMenuDialogFragment().show(requireActivity().supportFragmentManager, "ChoiceSetMenuDialogFragmentTag")
        }
    }

    private fun addOnlyBurger(){
        Log.d(Tag,"addOnlyBurger called")
        var isSame = false

        Log.d("addOnlyBurger",FastFoodModel.foodSelectedList.toString())
        applyPay()

        for (i in 0..FastFoodModel.foodSelectedList.size-1){
            Log.d("addOnlyBurger food name",FastFoodModel.foodSelectedList[i].food.name.toString())
            Log.d("addOnlyBurger ordering food name",orderingFood.food.name.toString())

            Log.d("addOnlyBurger food totalPrice",FastFoodModel.foodSelectedList[i].totalPrice.toString())
            Log.d("addOnlyBurger ordering food totalPrice",orderingFood.totalPrice.toString())

            Log.d("addOnlyBurger ordering food totalPrice",orderingFood.toString())


            if(FastFoodModel.foodSelectedList[i].food.name == orderingFood.food.name && FastFoodModel.foodSelectedList[i].totalPrice == orderingFood.totalPrice){
                isSame = true
                FastFoodModel.foodSelectedList[i].foodCount++
            }
        }

        if (!isSame){
            FastFoodModel.foodSelectedList.add(orderingFood)
        }

        Log.d(Tag,FastFoodModel.foodSelectedList.toString())

        viewModel.orderListChanged()
    }

    private fun applyPay(){
        var payment : Int = (FastFoodModel.foodSelected.price)

        if (orderingFood.setDessert!=null){
            payment += orderingFood.setDessert!!.price + orderingFood.setDrink!!.price
        }
        orderingFood.totalPrice = payment
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.25).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}
