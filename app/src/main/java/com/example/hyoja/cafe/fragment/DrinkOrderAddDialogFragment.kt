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
import com.example.hyoja.cafe.model.Ade1
import com.example.hyoja.cafe.model.Ade2
import com.example.hyoja.cafe.model.Ade3
import com.example.hyoja.cafe.model.Ade4
import com.example.hyoja.cafe.model.Beverage1
import com.example.hyoja.cafe.model.Beverage2
import com.example.hyoja.cafe.model.Beverage3
import com.example.hyoja.cafe.model.Beverage4
import com.example.hyoja.cafe.model.BubbleMilk1
import com.example.hyoja.cafe.model.BubbleMilk2
import com.example.hyoja.cafe.model.BubbleMilk3
import com.example.hyoja.cafe.model.BubbleMilk4
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.Coffee1
import com.example.hyoja.cafe.model.Coffee2
import com.example.hyoja.cafe.model.Coffee3
import com.example.hyoja.cafe.model.Coffee4
import com.example.hyoja.cafe.model.Coffee5
import com.example.hyoja.cafe.model.Coffee6
import com.example.hyoja.cafe.model.Coffee7
import com.example.hyoja.cafe.model.Coffee8
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.model.Flatccino1
import com.example.hyoja.cafe.model.Flatccino2
import com.example.hyoja.cafe.model.Flatccino3
import com.example.hyoja.cafe.model.Flatccino4
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.model.NewMenu5
import com.example.hyoja.cafe.model.NewMenu6
import com.example.hyoja.cafe.model.NewMenu7
import com.example.hyoja.cafe.model.NewMenu8
import com.example.hyoja.cafe.model.Ready
import com.example.hyoja.cafe.model.Shake1
import com.example.hyoja.cafe.model.Shake2
import com.example.hyoja.cafe.model.Shake3
import com.example.hyoja.cafe.model.Shake4
import com.example.hyoja.cafe.model.Tea1
import com.example.hyoja.cafe.model.Tea2
import com.example.hyoja.cafe.model.Tea3
import com.example.hyoja.cafe.model.Tea4
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkOrderAddBinding

class DrinkOrderAddDialogFragment: DialogFragment() {
    lateinit var binding: FragmentDrinkOrderAddBinding
    private lateinit var viewModel: MenuListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val selectedDrinkItem: DrinkDataInterface = when(drink){
            "newMenu1" -> NewMenu1()
            "newMenu2" -> NewMenu2()
            "newMenu3" -> NewMenu3()
            "newMenu4" -> NewMenu4()
            "newMenu5" -> NewMenu5()
            "newMenu6" -> NewMenu6()
            "newMenu7" -> NewMenu7()
            "newMenu8" -> NewMenu8()
            "coffee1" -> Coffee1()
            "coffee2" -> Coffee2()
            "coffee3" -> Coffee3()
            "coffee4" -> Coffee4()
            "coffee5" -> Coffee5()
            "coffee6" -> Coffee6()
            "coffee7" -> Coffee7()
            "coffee8" -> Coffee8()
            "ade1" -> Ade1()
            "ade2" -> Ade2()
            "ade3" -> Ade3()
            "ade4" -> Ade4()
            "shake1" -> Shake1()
            "shake2" -> Shake2()
            "shake3" -> Shake3()
            "shake4" -> Shake4()
            "beverage1" -> Beverage1()
            "beverage2" -> Beverage2()
            "beverage3" -> Beverage3()
            "beverage4" -> Beverage4()
            "tea1" -> Tea1()
            "tea2" -> Tea2()
            "tea3" -> Tea3()
            "tea4" -> Tea4()
            "bubbleMilk1" -> BubbleMilk1()
            "bubbleMilk2" -> BubbleMilk2()
            "bubbleMilk3" -> BubbleMilk3()
            "bubbleMilk4" -> BubbleMilk4()
            "flatccino1" -> Flatccino1()
            "flatccino2" -> Flatccino2()
            "flatccino3" -> Flatccino3()
            "flatccino4" -> Flatccino4()
            else -> Ready()
        }
        // 음료 이미지
        binding.addDrinkImage.setImageResource(selectedDrinkItem.drinkImage)
        // 음료 이름
        binding.drinkName.text = selectedDrinkItem.name
        // 음료 가격
        binding.drinkPrice.text = selectedDrinkItem.price.toString()
    }
}