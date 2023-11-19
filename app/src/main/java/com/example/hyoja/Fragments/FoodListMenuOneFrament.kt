package com.example.hyoja.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.util.DrinkDataFactory
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentFoodListNewMenuOneBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.util.FoodDataFactory
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FoodListMenuOneFrament : Fragment() {
    private val Tag: String = "FoodListMenuOneFragment"

    lateinit var binding: FragmentFoodListNewMenuOneBinding

    //현재 선택한 카테고리의 음료리스트
    private lateinit var foodArrayList : ArrayList<FoodDataInterface>

    //뷰모델
    private lateinit var viewModel : FoodListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(Tag,"onViewCreated called")

        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        viewModel.categoryLiveData.observe(requireActivity(),Observer{
            getFoodArrayList(it)
            setUI()
        })

        binding.burger1.setOnClickListener {
            callOrderFood(foodArrayList[0])
        }

        binding.burger2.setOnClickListener {
            callOrderFood(foodArrayList[1])
        }

        binding.burger3.setOnClickListener {
            callOrderFood(foodArrayList[2])
        }

        binding.burger4.setOnClickListener {
            callOrderFood(foodArrayList[3])
        }

        binding.burger5.setOnClickListener {
            callOrderFood(foodArrayList[4])
        }

        binding.burger6.setOnClickListener {
            callOrderFood(foodArrayList[5])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(Tag,"onCreateView called")
        binding = FragmentFoodListNewMenuOneBinding.inflate(inflater, container, false)

        //맨 처음 oncreate상황에서는 newMenu 받아와야함
        //현재 보여질 음료 카테고리 리스트를 newMenu로 설정
        //받아온 정보를 통해 UI세팅
        val foodData = FoodDataFactory()
        foodArrayList = foodData.getNewMenuArrayList()
        setUI()

        return binding.root
    }

    private fun getFoodArrayList(category: String){
        val foodData = FoodDataFactory()

        when(category){
            "newMenu" -> {
                foodArrayList = foodData.getNewMenuArrayList()
            }
            "hamburger" -> {
                foodArrayList = foodData.getHamburgerArrayList()
            }
            "dessert" -> {
                foodArrayList = foodData.getDessertArrayList()
            }
            "drink" -> {
                foodArrayList = foodData.getDrinkArrayList()
            }
        }
    }

    //전체 UI 세팅
    private fun setUI(){
        setButtonUI1(foodArrayList[0])
        setButtonUI2(foodArrayList[1])
        setButtonUI3(foodArrayList[2])
        setButtonUI4(foodArrayList[3])
        setButtonUI5(foodArrayList[4])
        setButtonUI6(foodArrayList[5])
    }

    private fun setButtonUI1(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger1Image.setImageResource(FoodData.foodImage)
        binding.burger1Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger1Price.text = ""
        }
        else{
            binding.burger1Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI2(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger2Image.setImageResource(FoodData.foodImage)
        binding.burger2Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger2Price.text = ""
        }
        else{
            binding.burger2Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI3(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger3Image.setImageResource(FoodData.foodImage)
        binding.burger3Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger3Price.text = ""
        }
        else{
            binding.burger3Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI4(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger4Image.setImageResource(FoodData.foodImage)
        binding.burger4Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger4Price.text = ""
        }
        else{
            binding.burger4Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI5(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger5Image.setImageResource(FoodData.foodImage)
        binding.burger5Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger5Price.text = ""
        }
        else{
            binding.burger5Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI6(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.burger6Image.setImageResource(FoodData.foodImage)
        binding.burger6Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.burger6Price.text = ""
        }
        else{
            binding.burger6Price.text = FoodData.price.toString()
        }
    }

    private fun callOrderFood(foodData: FoodDataInterface){
        if(foodData.category != "ready"){
            FastFoodModel.foodSelected = foodData
            viewModel.foodSelectChanged()
            Log.d(Tag,"FoodSelected ="+FastFoodModel.foodSelected)
        }
    }
}