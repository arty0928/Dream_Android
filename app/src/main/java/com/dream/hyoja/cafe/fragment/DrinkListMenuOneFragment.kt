package com.dream.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.R
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.model.DrinkDataInterface
import com.dream.hyoja.cafe.util.DrinkDataFactory
import com.dream.hyoja.cafe.viewmodel.MenuListViewModel
import com.dream.hyoja.databinding.FragmentDrinkListNewMenuOneBinding

class DrinkListMenuOneFragment : Fragment() {
    private val Tag: String = "DrinkListNewMenuOneFragment"
    lateinit var binding: FragmentDrinkListNewMenuOneBinding
    // 현재 선택한 카테고리의 음료리스트
    private lateinit var drinkArrayList: ArrayList<DrinkDataInterface>
    // 뷰모델
    private lateinit var viewModel: MenuListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]

        viewModel.categoryLiveData.observe(requireActivity(), Observer {
            getDrinkArrayList(it)
            setUI()
        })

        //버튼 리스너
        binding.newMenu1.setOnClickListener{
            callOrderDrink(drinkArrayList[0])
        }
        binding.newMenu2.setOnClickListener{
            callOrderDrink(drinkArrayList[1])
        }
        binding.newMenu3.setOnClickListener{
            callOrderDrink(drinkArrayList[2])
        }
        binding.newMenu4.setOnClickListener{
            callOrderDrink(drinkArrayList[3])
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuOneBinding.inflate(inflater, container, false)

        //맨 처음 oncreate상황에서는 newMenu 받아와야함
        //현재 보여질 음료 카테고리 리스트를 newMenu로 설정
        //받아온 정보를 통해 UI세팅
        val drinkData = DrinkDataFactory()
        drinkArrayList = drinkData.getNewMenuArrayList()
        setUI()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // 뷰를 리프레시
        refreshViews()
    }

    private fun getDrinkArrayList(categroy: String) {
        val drinkData = DrinkDataFactory()

        when (categroy) {
            "newMenu" -> {
                drinkArrayList = drinkData.getNewMenuArrayList()
            }
            "ade" -> {
                drinkArrayList = drinkData.getAdeArrayList()
            }
            "shake" -> {
                drinkArrayList = drinkData.getShakeArrayList()
            }
            "coffee" -> {
                drinkArrayList = drinkData.getCoffeeArrayList()
            }
            "tea" -> {
                drinkArrayList = drinkData.getTeaArrayList()
            }
            "flatccino" -> {
                drinkArrayList = drinkData.getFlatccinoArrayList()
            }
            "beverage" -> {
                drinkArrayList = drinkData.getBeverageArrayList()
            }
            "bubbleMilk" -> {
                drinkArrayList = drinkData.getBubbleMilkArrayList()
            }
        }
    }

    //전체 UI 세팅
    private fun setUI() {
        setButtonUI1(drinkArrayList[0])
        setButtonUI2(drinkArrayList[1])
        setButtonUI3(drinkArrayList[2])
        setButtonUI4(drinkArrayList[3])
    }

    //버튼 UI 세팅
    private fun setButtonUI1(drinkData: DrinkDataInterface) {
        //이미지와 이름 세팅
        binding.menu1Image.setImageResource(drinkData.drinkImage)
        binding.menu1Name.text = drinkData.name
        //밑의 가격표
        if (drinkData.category == "ready") {
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu1Price.text = ""
            binding.wonImage1.setImageResource(drinkData.drinkImage)
        } else {
            binding.menu1Price.text = drinkData.price.toString()
            binding.wonImage1.setImageResource(R.drawable.won_purple)
        }
    }

    private fun setButtonUI2(drinkData: DrinkDataInterface) {
        //이미지와 이름 세팅
        binding.menu2Image.setImageResource(drinkData.drinkImage)
        binding.menu2Name.text = drinkData.name
        //밑의 가격표
        if (drinkData.category == "ready") {
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu2Price.text = ""
            binding.wonImage2.setImageResource(drinkData.drinkImage)
        } else {
            binding.menu2Price.text = drinkData.price.toString()
            binding.wonImage2.setImageResource(R.drawable.won_purple)
        }
    }

    private fun setButtonUI3(drinkData: DrinkDataInterface) {
        //이미지와 이름 세팅
        binding.menu3Image.setImageResource(drinkData.drinkImage)
        binding.menu3Name.text = drinkData.name
        //밑의 가격표
        if (drinkData.category == "ready") {
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu3Price.text = ""
            binding.wonImage3.setImageResource(drinkData.drinkImage)
        } else {
            binding.menu3Price.text = drinkData.price.toString()
            binding.wonImage3.setImageResource(R.drawable.won_purple)
        }
    }

    private fun setButtonUI4(drinkData: DrinkDataInterface) {
        //이미지와 이름 세팅
        binding.menu4Image.setImageResource(drinkData.drinkImage)
        binding.menu4Name.text = drinkData.name
        //밑의 가격표
        if (drinkData.category == "ready") {
            // 준비 중 데이터면 아예 안 보이게 설정
            binding.menu4Price.text = ""
            binding.wonImage4.setImageResource(drinkData.drinkImage)
        } else {
            binding.menu4Price.text = drinkData.price.toString()
            binding.wonImage4.setImageResource(R.drawable.won_purple)
        }
    }

    private fun callOrderDrink(drinkData: DrinkDataInterface) {
        if (drinkData.category != "ready") {
            CafeModel.drinkSelected = drinkData
            viewModel.drinkSelectChanged()
            Log.d(Tag, "drinkSelected= " + CafeModel.drinkSelected)
        }
    }

    private fun refreshViews() {
        val textViews = listOf(
            binding.menu1Price,
            binding.menu2Price,
            binding.menu3Price,
            binding.menu4Price
        )

        textViews.forEach { textView ->
            textView.setSingleLine(true)
            textView.ellipsize = null
        }
    }
}
