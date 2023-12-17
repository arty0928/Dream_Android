package com.dream.hyoja

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.databinding.FragmentFoodCategoryBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class FoodCategoryFragment : Fragment() {
    private lateinit var viewModel : FoodListViewModel
    private val Tag: String = "FoodCategoryFragment"

    lateinit var binding: FragmentFoodCategoryBinding

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
                "newMenu" -> {
                    binding.categoryBtn1Lunch.setBackgroundResource(R.drawable.tab_indicator)

                }
                "hamburger" -> {
                    binding.categoryBtn2Hamburger.setBackgroundResource(R.drawable.tab_indicator)
                }
                "dessert" -> {
                    binding.categoryBtn3Dessert.setBackgroundResource(R.drawable.tab_indicator)
                }
                "drink" -> {
                    binding.categoryBtn4Drink.setBackgroundResource(R.drawable.tab_indicator)
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
        binding = FragmentFoodCategoryBinding.inflate(inflater,container,false)


        binding.categoryBtn1Lunch.setOnClickListener{
            FastFoodModel.menuCategory = "newMenu"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.categoryBtn2Hamburger.setOnClickListener {
            FastFoodModel.menuCategory = "hamburger"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.categoryBtn3Dessert.setOnClickListener {
            FastFoodModel.menuCategory = "dessert"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.categoryBtn4Drink.setOnClickListener {
            FastFoodModel.menuCategory = "drink"
            Log.d(Tag,"menuCategory = "+ FastFoodModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        return binding.root
    }
    private fun resetButtons() {
        binding.categoryBtn1Lunch.setBackgroundResource(R.drawable.tab_indicator_default)
        binding.categoryBtn2Hamburger.setBackgroundResource(R.drawable.tab_indicator_default)
        binding.categoryBtn3Dessert.setBackgroundResource(R.drawable.tab_indicator_default)
        binding.categoryBtn4Drink.setBackgroundResource(R.drawable.tab_indicator_default)
        Log.d(Tag,"resetButtonsCall")
    }


}
