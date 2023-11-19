package com.example.hyoja.Fragments

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
import com.example.hyoja.databinding.FragmentSetOrOnlyBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood
import com.example.hyoja.fastfoods.util.ApplyFoodOrderList
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class SetOrOnlyFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentSetOrOnlyBinding
    lateinit var viewModel: FoodListViewModel

    private val option :ArrayList<String> =ArrayList()

    private val setOption :ArrayList<String> =ArrayList()

    val orderingFood : OrderingFood = OrderingFood(
        food = FastFoodModel.foodSelected,
        option = option,
        setOption = setOption,
        setDessert = null,
        setDrink = null
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

            ApplyFoodOrderList(FastFoodModel.currentActivity)

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
        FastFoodModel.foodSelectedList.add(orderingFood)
        Log.d(Tag,FastFoodModel.foodSelectedList.toString())

        applyPay()
        viewModel.orderListChanged()
    }

    private fun applyPay(){
        var payment : Int = (FastFoodModel.foodSelected.price)
        orderingFood.price = payment
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
