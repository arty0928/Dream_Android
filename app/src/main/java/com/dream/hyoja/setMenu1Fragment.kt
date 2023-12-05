package com.dream.hyoja

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.Fragments.ChoiceSetMenuDialogFragment
import com.dream.hyoja.databinding.FragmentSetMenu1Binding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.setMenuDataInterface
import com.dream.hyoja.fastfoods.util.FoodDataFactory
import com.dream.hyoja.fastfoods.util.SetMenuDataFactory
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

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
            addSetMenuArrayList(it)
            setUI()
        })

        binding.setMenuDessert1.setOnClickListener {
//            resetButtons()

//            binding.setMenuDessert1.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[0])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[0])
        }

        binding.setMenuDeseert2.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDeseert2.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[1])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[1])

        }

        binding.setMenuDeseert3.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDeseert3.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[2])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[2])

        }

        binding.setMenuDessert4.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert4.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[3])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[3])

        }

        binding.setMenuDessert5.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert5.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[4])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[4])

        }

        binding.setMenuDessert6.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert6.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[5])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[5])

        }
        binding.setMenuDessert7.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert7.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[6])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[6])

        }
        binding.setMenuDessert8.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert8.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[7])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[7])

        }
        binding.setMenuDessert9.setOnClickListener {
//            resetButtons()
//
//            binding.setMenuDessert9.setBackgroundResource(R.drawable.layout_transparent_back_yellow_border)

            callOrderFood(setMenuArrayList[8])
            (parentFragment as ChoiceSetMenuDialogFragment).setSetDessert(setMenuArrayList[8])

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(Tag,"onCreateView called")

        val parentFragment = parentFragment
        if (parentFragment is ChoiceSetMenuDialogFragment) {
            // OrderingFood 객체를 가져오고, 형변환 후에 사용
            val orderingFood = parentFragment.orderingFood
            Log.d(Tag, orderingFood.toString())
        }

        binding = FragmentSetMenu1Binding.inflate(inflater,container,false)

        val setMenuData = SetMenuDataFactory()
        setMenuArrayList = setMenuData.getsetDessertArrayList()
        setUI()

        return binding.root

    }

    private fun addSetMenuArrayList(category: String) {
        val setMenu = FoodDataFactory()

        when(category) {
            "setDessert" -> {
                setMenuArrayList = setMenu.getsetDessertArrayList()
                binding.setMenuTitile.text = "선택하신 버거와 가장 잘 어울리는 Best 디저트!"
            }"setDrink" -> {
            setMenuArrayList = setMenu.getsetDrinkArrayList()
            binding.setMenuTitile.text = "선택하신 버거와 가장 잘 어울리는 Best 드링크!"

        }
        }

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

    private fun callOrderFood(foodData: setMenuDataInterface) {
        FastFoodModel.setMenuFoodSelected = foodData // 사용자가 선택한 메뉴를 FastFoodModel에 저장

        val parentFragment = parentFragment
        if (parentFragment is ChoiceSetMenuDialogFragment) {
            // OrderingFood 객체를 가져오고, 형변환 후에 사용
            val orderingFood = parentFragment.orderingFood

            Log.d(Tag, "들어옴")

            // setDessert에 선택한 메뉴를 할당
            if(foodData.category == "setDessert"){
                orderingFood.setDessert = FastFoodModel.setMenuFoodSelected
            }
            else{
                orderingFood.setDrink = FastFoodModel.setMenuFoodSelected
            }

            // ViewModel의 setMenuSelectChanged() 메서드 호출
            parentFragment.viewModel.setMenuSelectChanged()
            parentFragment.updateCountText()
            Log.d(Tag, orderingFood.toString())

            Log.d(Tag, "setMenuSelected = ${FastFoodModel.setMenuFoodSelected}")
        } else {
            Log.e(Tag, "부모 프래그먼트가 ChoiceSetMenuDialogFragment가 아닙니다.")
        }
    }

    private fun resetButtons(){
        binding.setMenuDessert1.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDeseert2.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDeseert3.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert4.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert5.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert6.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert7.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert8.setBackgroundResource(R.drawable.ready_white)
        binding.setMenuDessert9.setBackgroundResource(R.drawable.ready_white)
        Log.d(Tag,"resetButtonsCall")

    }

}