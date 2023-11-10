package com.example.hyoja

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.databinding.FragmentSetMenu1Binding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.model.setMenuDataInterface
import com.example.hyoja.fastfoods.util.FoodDataFactory
import com.example.hyoja.fastfoods.util.SetMenuDataFactory
import com.example.hyoja.fastfoods.util.setMenuFoodUtilValue
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class setMenu1Fragment : Fragment() {
    private val Tag: String = "setMenu1Fragment"

    lateinit var binding : FragmentSetMenu1Binding

    private lateinit var setMenuArrayList : ArrayList<setMenuDataInterface>

    private lateinit var viewModel : FoodListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(Tag,"onViewCreated called")

        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        viewModel.setMenuCategoryLiveData.observe(requireActivity(), Observer{
            getSetMenuArrayList(it)
            setUI()
        })

        binding.setMenuDessert1.setOnClickListener {
            callOrderFood(setMenuArrayList[0])
        }

        binding.setMenuDeseert2.setOnClickListener {
            callOrderFood(setMenuArrayList[1])
        }

        binding.setMenuDeseert3.setOnClickListener {
            callOrderFood(setMenuArrayList[2])
        }

        binding.setMenuDessert4.setOnClickListener {
            callOrderFood(setMenuArrayList[3])
        }

        binding.setMenuDessert5.setOnClickListener {
            callOrderFood(setMenuArrayList[4])
        }

        binding.setMenuDessert6.setOnClickListener {
            callOrderFood(setMenuArrayList[5])
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(Tag,"onCreateView called")

        binding = FragmentSetMenu1Binding.inflate(inflater,container,false)

        val setMenuData = SetMenuDataFactory()
        setMenuArrayList = setMenuData.getsetDessertArrayList()
        setUI()

        return binding.root

    }

    private fun getSetMenuArrayList(category: String){
        val foodData = SetMenuDataFactory()

        when(category){
            "setDessert" -> {
                setMenuArrayList = foodData.getsetDessertArrayList()
            }
            "setDrink" -> {
                setMenuArrayList = foodData.getsetDrinkArrayList()
            }
        }
    }

    private fun setUI(){
        setButtonUI1(setMenuArrayList[0])
        setButtonUI2(setMenuArrayList[1])
        setButtonUI3(setMenuArrayList[2])
        setButtonUI4(setMenuArrayList[3])
        setButtonUI5(setMenuArrayList[4])
        setButtonUI6(setMenuArrayList[5])
        setButtonUI7(setMenuArrayList[6])
        setButtonUI8(setMenuArrayList[7])
        setButtonUI9(setMenuArrayList[8])
    }

    private fun setButtonUI1(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDeseert1Image.setImageResource(setData.foodImage)
        binding.setMenuDeseert1Name.text = setData.name
        binding.setMenuDeseert1Price.text = setData.price.toString()
    }

    private fun setButtonUI2(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDeseert2Image.setImageResource(setData.foodImage)
        binding.setMenuDeseert2Name.text = setData.name
        binding.setMenuDeseert2Price.text = setData.price.toString()
    }

    private fun setButtonUI3(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDeseert3Image.setImageResource(setData.foodImage)
        binding.setMenuDeseert3Name.text = setData.name
        binding.setMenuDeseert3Price.text = setData.price.toString()
    }

    private fun setButtonUI4(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert4Image.setImageResource(setData.foodImage)
        binding.setMenuDessert4Name.text = setData.name
        binding.setMenuDessert4Price.text = setData.price.toString()
    }

    private fun setButtonUI5(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert5Image.setImageResource(setData.foodImage)
        binding.setMenuDessert5Name.text = setData.name
        binding.setMenuDessert5Price.text = setData.price.toString()
    }

    private fun setButtonUI6(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert6Image.setImageResource(setData.foodImage)
        binding.setMenuDessert6Name.text = setData.name
        binding.setMenuDessert6Price.text = setData.price.toString()
    }

    private fun setButtonUI7(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert7Image.setImageResource(setData.foodImage)
        binding.setMenuDessert7Name.text = setData.name
        binding.setMenuDessert7Price.text = setData.price.toString()
    }

    private fun setButtonUI8(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert8Image.setImageResource(setData.foodImage)
        binding.setMenuDessert8Name.text = setData.name
        binding.setMenuDessert8Price.text = setData.price.toString()
    }

    private fun setButtonUI9(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDessert9Image.setImageResource(setData.foodImage)
        binding.setMenuDessert9Name.text = setData.name
        binding.setMenuDessert9Price.text = setData.price.toString()
    }

    private fun callOrderFood(foodData: setMenuDataInterface){
        FastFoodModel.setMenuFoodSelected = foodData
        viewModel.setMenuSelectChanged()
        Log.d(Tag,"setMenuSelected ="+ FastFoodModel.setMenuFoodSelected)
    }
}