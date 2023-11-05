package com.example.hyoja

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentFoodCategoryBinding
import com.example.hyoja.databinding.FragmentMenuCategoryOneBinding
import com.example.hyoja.databinding.FragmentSetMenuChoiceCategoryBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class SetMenuChoiceCategoryFragment : Fragment() {
    private lateinit var viewModel : FoodListViewModel
    private val Tag: String = "FoodCategoryFragment"

    lateinit var binding: FragmentSetMenuChoiceCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //메뉴리스트 뷰모델
        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        viewModel.categoryLiveData.observe(viewLifecycleOwner, Observer {
            resetButtons()
            when(it){
                "dessert" -> {
                    binding.SetMenuChoiceCategoryDessert.setBackgroundResource(R.drawable.tab_indicator)
                }
                "drink" -> {
                    binding.SetMenuChoiceCategoryDrink.setBackgroundResource(R.drawable.tab_indicator)
                }
            }
        })
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSetMenuChoiceCategoryBinding.inflate(inflater,container,false)

        binding.SetMenuChoiceCategoryDessert.setOnClickListener{
            FastFoodModel.menuCategory = "dessert"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.SetMenuChoiceCategoryDrink.setOnClickListener {
            FastFoodModel.menuCategory = "drink"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        return binding.root
    }
    private fun resetButtons() {
        binding.SetMenuChoiceCategoryDessert.setBackgroundResource(R.drawable.tab_indicator_setmenu_default)
        binding.SetMenuChoiceCategoryDrink.setBackgroundResource(R.drawable.tab_indicator_setmenu_default)
        Log.d(Tag,"resetButtonsCall")
    }


}
