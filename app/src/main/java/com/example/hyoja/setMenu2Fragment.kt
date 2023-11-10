package com.example.hyoja

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.databinding.FragmentSetMenu2Binding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.setMenuDataInterface
import com.example.hyoja.fastfoods.util.SetMenuDataFactory
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class setMenu2Fragment : Fragment() {
    private val Tag: String = "setMenu2Fragment"

    private lateinit var binding : FragmentSetMenu2Binding

    private lateinit var setMenuArrayList : ArrayList<setMenuDataInterface>

    private lateinit var viewModel : FoodListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(Tag, "onViewCreated called")

        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        viewModel.setMenuCategoryLiveData.observe(requireActivity(), Observer {
            getSetMenuArrayList(it)
            setUI()
        })

        binding.setMenuDrink1.setOnClickListener {
            callOrderFood(setMenuArrayList[0])
        }

        binding.setMenuDrink2.setOnClickListener {
            callOrderFood(setMenuArrayList[1])
        }

        binding.setMenuDrink3.setOnClickListener {
            callOrderFood(setMenuArrayList[2])
        }

        binding.setMenuDrink4.setOnClickListener {
            callOrderFood(setMenuArrayList[3])
        }

        binding.setMenuDrink5.setOnClickListener {
            callOrderFood(setMenuArrayList[4])
        }

        binding.setMenuDrink6.setOnClickListener {
            callOrderFood(setMenuArrayList[5])
        }

        binding.setMenuDrink7.setOnClickListener {
            callOrderFood(setMenuArrayList[6])
        }

        binding.setMenuDrink8.setOnClickListener {
            callOrderFood(setMenuArrayList[7])
        }

        binding.setMenuDrink9.setOnClickListener {
            callOrderFood(setMenuArrayList[8])
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(Tag, "onCreateView called")

        binding = FragmentSetMenu2Binding.inflate(inflater,container,false)

        val setMenuData = SetMenuDataFactory()
        setMenuArrayList = setMenuData.getsetDrinkArrayList()
        setUI()

        return binding.root
    }

    private fun getSetMenuArrayList(category : String){
        val foodData = SetMenuDataFactory()

        when(category){
            "setDessert" -> {
                setMenuArrayList = foodData.getsetDessertArrayList()
            }"setDrink" -> {
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
        binding.setMenuDrink1Image.setImageResource(setData.foodImage)
        binding.setMenuDrink1Name.text = setData.name
        binding.setMenuDrink1Price.text = setData.price.toString()
    }

    private fun setButtonUI2(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink2Image.setImageResource(setData.foodImage)
        binding.setMenuDrink2Name.text = setData.name
        binding.setMenuDrink2Price.text = setData.price.toString()
    }

    private fun setButtonUI3(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink3Image.setImageResource(setData.foodImage)
        binding.setMenuDrink3Name.text = setData.name
        binding.setMenuDrink3Price.text = setData.price.toString()
    }

    private fun setButtonUI4(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink4Image.setImageResource(setData.foodImage)
        binding.setMenuDrink4Name.text = setData.name
        binding.setMenuDrink4Price.text = setData.price.toString()
    }

    private fun setButtonUI5(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink5Image.setImageResource(setData.foodImage)
        binding.setMenuDrink5Name.text = setData.name
        binding.setMenuDrink5Price.text = setData.price.toString()
    }

    private fun setButtonUI6(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink6Image.setImageResource(setData.foodImage)
        binding.setMenuDrink6Name.text = setData.name
        binding.setMenuDrink6Price.text = setData.price.toString()
    }

    private fun setButtonUI7(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink7Image.setImageResource(setData.foodImage)
        binding.setMenuDrink7Name.text = setData.name
        binding.setMenuDrink7Price.text = setData.price.toString()
    }

    private fun setButtonUI8(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink8Image.setImageResource(setData.foodImage)
        binding.setMenuDrink8Name.text = setData.name
        binding.setMenuDrink8Price.text = setData.price.toString()
    }

    private fun setButtonUI9(setData: setMenuDataInterface){
        //이미지와 이름 세팅
        binding.setMenuDrink9Image.setImageResource(setData.foodImage)
        binding.setMenuDrink9Name.text = setData.name
        binding.setMenuDrink9Price.text = setData.price.toString()
    }

    private fun callOrderFood(foodData: setMenuDataInterface){
        FastFoodModel.setMenuFoodSelected = foodData
        viewModel.setMenuSelectChanged()
        Log.d(Tag,"setMenuSelected ="+ FastFoodModel.setMenuFoodSelected)
    }
}