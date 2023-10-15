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
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.model.NewMenu5
import com.example.hyoja.cafe.model.NewMenu6
import com.example.hyoja.cafe.model.NewMenu7
import com.example.hyoja.cafe.model.NewMenu8
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkOrderAddBinding

class DrinkOrderAddDialogFragment: DialogFragment() {
    lateinit var binding: FragmentDrinkOrderAddBinding
    private lateinit var viewModel: MenuListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkOrderAddBinding.inflate(inflater, container, false)
        val view = binding.root
        // 레이아웃 배경을 투명하게 해줌, 필수 아님
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

    fun setUi(){
        val drink = CafeModel.drinkSelected
        when(drink){
            "newMenu1" ->{
                binding.addDrinkImage.setImageResource(NewMenu1().drinkImage)
                binding.drinkName.text = NewMenu1().name
                binding.drinkPrice.text = NewMenu1().price.toString()
            }
            "newMenu2" ->{
                binding.addDrinkImage.setImageResource(NewMenu2().drinkImage)
                binding.drinkName.text = NewMenu2().name
                binding.drinkPrice.text = NewMenu2().price.toString()
            }
            "newMenu3" ->{
                binding.addDrinkImage.setImageResource(NewMenu3().drinkImage)
                binding.drinkName.text = NewMenu3().name
                binding.drinkPrice.text = NewMenu3().price.toString()
            }
            "newMenu4" ->{
                binding.addDrinkImage.setImageResource(NewMenu4().drinkImage)
                binding.drinkName.text = NewMenu4().name
                binding.drinkPrice.text = NewMenu4().price.toString()
            }
            "newMenu5" ->{
                binding.addDrinkImage.setImageResource(NewMenu5().drinkImage)
                binding.drinkName.text = NewMenu5().name
                binding.drinkPrice.text = NewMenu5().price.toString()
            }
            "newMenu6" ->{
                binding.addDrinkImage.setImageResource(NewMenu6().drinkImage)
                binding.drinkName.text = NewMenu6().name
                binding.drinkPrice.text = NewMenu6().price.toString()
            }
            "newMenu7" ->{
                binding.addDrinkImage.setImageResource(NewMenu7().drinkImage)
                binding.drinkName.text = NewMenu7().name
                binding.drinkPrice.text = NewMenu7().price.toString()
            }
            "newMenu8" ->{
                binding.addDrinkImage.setImageResource(NewMenu8().drinkImage)
                binding.drinkName.text = NewMenu8().name
                binding.drinkPrice.text = NewMenu8().price.toString()
            }
        }

    }
}