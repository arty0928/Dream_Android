package com.example.hyoja.cafe.fragment

import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkOrderAddBinding

class DrinkOrderAddDialogFragment: DialogFragment() {
    lateinit var binding: FragmentDrinkOrderAddBinding
    private lateinit var viewModel: MenuListViewModel
    private val selectedDrinkItem = CafeModel.drinkSelected
    val freeOption:ArrayList<String> = ArrayList()
    val option:ArrayList<String> = ArrayList()
    val orderingDrink:OrderingDrink = OrderingDrink("hot",freeOption,option,CafeModel.drinkSelected)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 음료 추가 및 빼기
        binding.itemPlus.setOnClickListener{
            addDrinkCount()
        }
        binding.itemMinus.setOnClickListener{
            minusDrinkCount()
        }

        // 음료 사이즈
        binding.regularButton.setOnClickListener {
            regularButtonClicked()
        }
        binding.extraButton.setOnClickListener {
            extraButtonClicked()
        }

        // 음료 온도 선택
        binding.icedButton.setOnClickListener {
            icedButtonClicked()
        }
        binding.hotButton.setOnClickListener {
            hotButtonClicked()
        }
        //취소 버튼
        binding.cancelButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkOrderAddBinding.inflate(inflater, container, false)
        val view = binding.root
        // 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setUi()
        return view
    }
    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.75).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setUi(){
        // 음료 이미지
        binding.addDrinkImage.setImageResource(selectedDrinkItem.drinkImage)
        // 음료 이름
        binding.drinkName.text = selectedDrinkItem.name
        // 음료 가격
        binding.drinkPrice.text = selectedDrinkItem.price.toString()
        setDegreeUI()
    }
    private fun setDegreeUI(){
        val degree = selectedDrinkItem.degree
        if (!degree){//false일 때
            binding.hotButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_gray))
            binding.icedButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_gray))
        }
    }
    private fun hotButtonClicked(){
        if(selectedDrinkItem.degree){
            binding.hotButton.setBackgroundResource(R.drawable.hot_button_clicked)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_white))
            binding.icedButton.setBackgroundResource(R.drawable.iced_button_unclicked)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_skyblue))
        }
    }

    private fun icedButtonClicked(){
        if(selectedDrinkItem.degree) {
            binding.hotButton.setBackgroundResource(R.drawable.hot_button_unclicked)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_darkRed))
            binding.icedButton.setBackgroundResource(R.drawable.iced_button_clicked)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_white))
        }
    }
    private fun regularButtonClicked(){
        binding.regularButton.setBackgroundResource(R.drawable.hot_button_unclicked)
        binding.extraButton.setBackgroundResource(R.drawable.border_line)
    }
    private fun extraButtonClicked(){
        binding.extraButton.setBackgroundResource(R.drawable.hot_button_unclicked)
        binding.regularButton.setBackgroundResource(R.drawable.border_line)
    }
    private fun addDrinkCount(){
        orderingDrink.drinkCount++
        binding.itemNum.text = orderingDrink.drinkCount.toString()
    }
    private fun minusDrinkCount(){
        orderingDrink.drinkCount--
        binding.itemNum.text = orderingDrink.drinkCount.toString()
    }
    private fun checkPay(){
        
    }
}