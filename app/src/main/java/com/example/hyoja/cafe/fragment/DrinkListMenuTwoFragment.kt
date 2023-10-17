package com.example.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.viewmodel.MenuListViewModel

import com.example.hyoja.cafe.util.DrinkDataFactory
import com.example.hyoja.databinding.FragmentDrinkListNewMenuTwoBinding

class DrinkListMenuTwoFragment : Fragment() {
    private val Tag: String = "DrinkListNewMenuTwoFragment"
    lateinit var binding: FragmentDrinkListNewMenuTwoBinding
    // 현재 선택한 카테고리의 음료리스트
    private lateinit var drinkArrayList: ArrayList<DrinkDataInterface>
    // 뷰모델
    private lateinit var viewModel: MenuListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]


        //버튼 리스너
        binding.newMenu1.setOnClickListener{
            CafeModel.drinkSelected = "drink1"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu2.setOnClickListener{
            CafeModel.drinkSelected = "drink2"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu3.setOnClickListener{
            CafeModel.drinkSelected = "drink3"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu4.setOnClickListener{
            CafeModel.drinkSelected = "drink4"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuTwoBinding.inflate(inflater, container, false)

        //맨 처음 oncreate상황에서는 newMenu 받아와야함
        //현재 보여질 음료 카테고리 리스트를 newMenu로 설정
        //받아온 정보를 통해 UI세팅
        val drinkData: DrinkDataFactory = DrinkDataFactory()
        drinkArrayList = drinkData.getNewMenuArrayList()
        setUI()

        return binding.root
    }

    //전체 UI 세팅
    private fun setUI(){
        setButtonUI1(drinkArrayList[4])
        setButtonUI2(drinkArrayList[5])
        setButtonUI3(drinkArrayList[6])
        setButtonUI4(drinkArrayList[7])
    }

    //버튼 UI 세팅
    private fun setButtonUI1(drinkData:DrinkDataInterface){
        //이미지와 이름 세팅
        binding.menu1Image.setImageResource(drinkData.drinkImage)
        binding.menu1Name.text = drinkData.name
        //밑의 가격표
        if(drinkData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu1Price.text = ""
            binding.wonImage1.setImageResource(drinkData.drinkImage)
        }
        else{
            binding.menu1Price.text = drinkData.price.toString()
        }
    }
    private fun setButtonUI2(drinkData:DrinkDataInterface){
        //이미지와 이름 세팅
        binding.menu2Image.setImageResource(drinkData.drinkImage)
        binding.menu2Name.text = drinkData.name
        //밑의 가격표
        if(drinkData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu2Price.text = ""
            binding.wonImage2.setImageResource(drinkData.drinkImage)
        }
        else{
            binding.menu2Price.text = drinkData.price.toString()
        }
    }
    private fun setButtonUI3(drinkData:DrinkDataInterface){
        //이미지와 이름 세팅
        binding.menu3Image.setImageResource(drinkData.drinkImage)
        binding.menu3Name.text = drinkData.name
        //밑의 가격표
        if(drinkData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu3Price.text = ""
            binding.wonImage3.setImageResource(drinkData.drinkImage)
        }
        else{
            binding.menu3Price.text = drinkData.price.toString()
        }
    }
    private fun setButtonUI4(drinkData:DrinkDataInterface){
        //이미지와 이름 세팅
        binding.menu4Image.setImageResource(drinkData.drinkImage)
        binding.menu4Name.text = drinkData.name
        //밑의 가격표
        if(drinkData.category == "ready"){
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu4Price.text = ""
            binding.wonImage4.setImageResource(drinkData.drinkImage)
        }
        else{
            binding.menu4Price.text = drinkData.price.toString()
        }
    }

}