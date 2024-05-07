package com.dream.hyoja.Fragments.FoodList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.databinding.FragmentFoodListNewMenuTwoBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.FoodDataInterface
import com.dream.hyoja.fastfoods.util.FoodDataFactory
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class FoodListMenuTwoFragment : Fragment() {
    private val Tag: String = "FoodListMenuOneFragment"

    lateinit var binding: FragmentFoodListNewMenuTwoBinding

    //현재 선택한 카테고리의 음료리스트
    private lateinit var foodArrayList : ArrayList<FoodDataInterface>

    //뷰모델
    private lateinit var viewModel : FoodListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(Tag,"onViewCreated called")

        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

        viewModel.categoryLiveData.observe(requireActivity(), Observer{
            getFoodArrayList(it)
            setUI()
        })

        binding.newMenu1.setOnClickListener {
            callOrderFood(foodArrayList[6])
        }

        binding.newMenu2.setOnClickListener {
            callOrderFood(foodArrayList[7])
        }

        binding.newMenu3.setOnClickListener {
            callOrderFood(foodArrayList[8])
        }

        binding.newMenu4.setOnClickListener {
            callOrderFood(foodArrayList[9])
        }

        binding.newMenu5.setOnClickListener {
            callOrderFood(foodArrayList[10])
        }

        binding.newMenu6.setOnClickListener {
            callOrderFood(foodArrayList[11])
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
        binding = FragmentFoodListNewMenuTwoBinding.inflate(inflater, container, false)

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
        // 밑의 조건문을 통해 fragment2에 대한 IndexOutOfBoundsException 방어
        if(foodArrayList.size<=12){
            while(foodArrayList.size< 12){
                foodArrayList.add(com.dream.hyoja.fastfoods.model.Ready())
                Log.d("READY", "${foodArrayList}")

            }
        }

        if (foodArrayList.size >= 7) {
            Log.d("FoodSetUI", "${foodArrayList.size}")
            Log.d("FoodSetUI", "${foodArrayList}")
            for (i in 7..foodArrayList.size) {
                val functionName = "setButtonUI$i"
                val foodIndex = i - 1
                Log.d("FoodSetUI", "${foodArrayList[foodIndex]}")
                // 아래에서 setButtonUI 함수를 호출할 수 있습니다.
                when (i) {
                    7 -> setButtonUI6(foodArrayList[foodIndex])
                    8 -> setButtonUI7(foodArrayList[foodIndex])
                    9 -> setButtonUI8(foodArrayList[foodIndex])
                    10 -> setButtonUI9(foodArrayList[foodIndex])
                    11 -> setButtonUI10(foodArrayList[foodIndex])
                    12 -> setButtonUI11(foodArrayList[foodIndex])
                    // 추가적인 케이스도 필요한 경우 4, 5, 6, 7에 대한 처리를 추가하세요.
                }
            }
        }

    }

    private fun setButtonUI6(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu1Image.setImageResource(FoodData.foodImage)
        binding.newMenu1Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newmenu1Price.text = ""
            binding.newMenu1Name.text = ""
        }
        else{
            binding.newmenu1Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI7(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu2Image.setImageResource(FoodData.foodImage)
        binding.newMenu2Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newMenu2Name.text = ""
            binding.newMenu2Price.text = ""
        }
        else{
            binding.newMenu2Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI8(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu3Image.setImageResource(FoodData.foodImage)
        binding.newMenu3Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newMenu3Price.text = ""
            binding.newMenu3Name.text = ""

        }
        else{
            binding.newMenu3Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI9(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu4Image.setImageResource(FoodData.foodImage)
        binding.newMenu4Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newMenu4Price.text = ""
            binding.newMenu3Name.text = ""

        }
        else{
            binding.newMenu4Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI10(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu5Image.setImageResource(FoodData.foodImage)
        binding.newMenu5Name.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newMenu5Price.text = ""
            binding.newMenu3Name.text = ""

        }
        else{
            binding.newMenu5Price.text = FoodData.price.toString()
        }
    }

    private fun setButtonUI11(FoodData: FoodDataInterface){
        //이미지와 이름 세팅
        binding.newMenu6Image.setImageResource(FoodData.foodImage)
        binding.newMenu6Price.text = FoodData.name
        //밑의 가격표
        if(FoodData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.newMenu6Price.text = ""
            binding.newMenu6Name.text = ""

        }
        else{
            binding.newMenu6Price.text = FoodData.price.toString()
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