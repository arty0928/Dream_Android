package com.example.hyoja.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.model.Ready
import com.example.hyoja.cafe.util.DrinkDataFactory
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkListNewMenuTwoBinding
import com.example.hyoja.databinding.FragmentFoodListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentFoodListNewMenuTwoBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.util.FoodDataFactory
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FoodListMenuTwoFragment : Fragment() {
    private val Tag: String = "FoodListNewMenuTwoFragment"
    lateinit var binding: FragmentFoodListNewMenuTwoBinding
    // 현재 선택한 카테고리의 음료리스트
    private lateinit var foodArrayList: ArrayList<FoodDataInterface>
    // 뷰모델
    private lateinit var viewModel: FoodListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        //버튼 리스너
        binding.newMenu1.setOnClickListener{
            callOrderFood(foodArrayList[6])
        }
        binding.newMenu2.setOnClickListener{
            callOrderFood(foodArrayList[7])
        }
        binding.NewMenu3.setOnClickListener{
            callOrderFood(foodArrayList[8])
        }
        binding.newMenu4.setOnClickListener{
            callOrderFood(foodArrayList[9])
        }

        binding.newMenu5.setOnClickListener{
            callOrderFood(foodArrayList[10])
        }

        binding.newMenu6.setOnClickListener{
            callOrderFood(foodArrayList[11])
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListNewMenuTwoBinding.inflate(inflater, container, false)

        //맨 처음 oncreate상황에서는 newMenu 받아와야함
        //현재 보여질 음료 카테고리 리스트를 newMenu로 설정
        //받아온 정보를 통해 UI세팅
        val foodData = FoodDataFactory()
        foodArrayList = foodData.getNewMenuArrayList()
        setUI()

        return binding.root
    }

    //전체 UI 세팅
    private fun setUI(){
        if (foodArrayList.size<=6){
            for (i in 6..11){
//                .add(Ready())
            }
        }
        setButtonUI1(foodArrayList[0])
        setButtonUI2(foodArrayList[1])
        setButtonUI3(foodArrayList[2])
        setButtonUI4(foodArrayList[3])
        setButtonUI5(foodArrayList[4])
        setButtonUI6(foodArrayList[5])

    }

    //버튼 UI 세팅
    private fun setButtonUI1(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu1Image.setImageResource(foodData.foodImage)
        binding.newMenu1Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu1Price.text = ""
            binding.newMenu1Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu1Price.text = foodData.price.toString()
        }
    }

    private fun setButtonUI2(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu2Image.setImageResource(foodData.foodImage)
        binding.newmenu2Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu2Price.text = ""
            binding.newMenu2Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu2Price.text = foodData.price.toString()
        }
    }

    private fun setButtonUI3(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu3Image.setImageResource(foodData.foodImage)
        binding.newMenu3Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu3Price.text = ""
            binding.newMenu3Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu3Price.text = foodData.price.toString()
        }
    }

    private fun setButtonUI4(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu4Image.setImageResource(foodData.foodImage)
        binding.newmenu4Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu4Price.text = ""
            binding.newMenu4Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu4Price.text = foodData.price.toString()
        }
    }

    private fun setButtonUI5(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu5Image.setImageResource(foodData.foodImage)
        binding.newMenu5Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu5Price.text = ""
            binding.newMenu5Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu5Price.text = foodData.price.toString()
        }
    }

    private fun setButtonUI6(foodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu6Image.setImageResource(foodData.foodImage)
        binding.newMenu6Name.text = foodData.name
        //밑의 가격표
        if(foodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu6Price.text = ""
            binding.newMenu6Image.setImageResource(foodData.foodImage)
        }
        else{
            binding.newmenu6Price.text = foodData.price.toString()
        }
    }


    private fun callOrderFood(foodData: FoodDataInterface){
        if (foodData.category != "ready"){
            FastFoodModel.foodSelected = foodData
            viewModel.foodSelectChanged()
            Log.d(Tag,"foodSelected= "+ FastFoodModel.foodSelected)
        }
    }

}
