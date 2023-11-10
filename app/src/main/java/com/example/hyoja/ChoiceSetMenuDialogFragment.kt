package com.example.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.databinding.FragmentChoiceSetMenuDialogBinding
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceCategoryAdapter
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceMainViewPagerAdapter
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood
import com.example.hyoja.fastfoods.util.FoodUtilValue
import com.example.hyoja.fastfoods.util.setMenuFoodUtilValue
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class ChoiceSetMenuDialogFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"
    private lateinit var binding: FragmentChoiceSetMenuDialogBinding
    private lateinit var viewModel: FoodListViewModel
    private val selectedFoodItem = FastFoodModel.foodSelected
    private val setOption:ArrayList<String> = ArrayList()
//    private val orderingFood : OrderingFood = OrderingFood(
//
//    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentChoiceSetMenuDialogBinding.inflate(inflater, container, false)

        val parentFragment = parentFragmentManager?.findFragmentByTag("SetOrOnlyFragment") as DialogFragment?
        parentFragment?.dismiss()

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        //카테고리 뷰페이저
        binding.SetMenuChoiceCategory.adapter = SetMenuChoiceCategoryAdapter(this)
        var currentCategory = binding.SetMenuChoiceCategory.currentItem
        binding.SetMenuChoiceCategory.isUserInputEnabled = false;

        binding.SetMenuChoiceMainViewPager.adapter = SetMenuChoiceMainViewPagerAdapter(this)
        binding.SetMenuChoiceMainViewPager.isUserInputEnabled = false;

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        var i=0
        viewModel.setMenuSelectedLiveData.observe(this, Observer {
            if(i>0){
                Log.d(Tag,"setMenuSelectedLiveData observed")
//                foodOptionFragmentManage()
            }
            i++
        })

        viewModel.setMenuCategoryLiveData.observe(this, Observer{
            when(it){
                "setDessert" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                "setDrink" -> {

                }else ->{

                }
            }
        })

        return binding.root
    }

    private fun checkFoodListViewPagerSize(categroyName: String):Int{
        //null허용은 해놨는데 절대 null되면 안됨
        var value = setMenuFoodUtilValue()
        var itemCount: Int? = when(categroyName){
            "setDessert" -> {
                value.setDessertListSize
            }
            "setDrink" -> {
                value.setDrinkListSize
            }
            else ->{
                return 0
            }
        }
        Log.d(Tag,"setFoodListCount = "+ itemCount.toString())
        // 뷰페이저 첫번째 프래그먼트로 전환
        binding.SetMenuChoiceMainViewPager.setCurrentItem(0,true)
        itemCount = itemCount?.div(9)
        return itemCount!!
    }

    private fun foodListButtonSrcSelect(itemCount:Int){

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이제 binding을 사용하여 UI 요소에 접근할 수 있습니다.
        // 예를 들어, binding.textView.text = "안녕하세요"와 같은 방식으로 UI 요소를 조작할 수 있습니다.
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.9).toInt(), (height * 0.85).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}
