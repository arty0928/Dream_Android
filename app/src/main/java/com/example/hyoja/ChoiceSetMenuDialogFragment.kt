package com.example.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.databinding.FragmentChoiceSetMenuDialogBinding
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceCategoryAdapter
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceMainViewPagerAdapter
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood
import com.example.hyoja.fastfoods.model.setMenuDataInterface
import com.example.hyoja.fastfoods.util.ApplyFoodOrderList
import com.example.hyoja.fastfoods.util.setMenuFoodUtilValue
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class ChoiceSetMenuDialogFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"
    lateinit var binding: FragmentChoiceSetMenuDialogBinding
    lateinit var viewModel: FoodListViewModel

    private val option :ArrayList<String> =ArrayList()
    private val setOption :ArrayList<String> =ArrayList()
    private val price : Int = 0
    private val category : String = "newMenu"

    val orderingFood : OrderingFood = OrderingFood(
        totalPrice = price,
        food = FastFoodModel.foodSelected,
        option = option,
        setOption = setOption,
        setDessert = null,
        setDrink = null,
        category = category
    )

    fun setSetDessert(dessert: setMenuDataInterface) {
        orderingFood.setDessert = dessert
    }

    fun setSetDrink(drink : setMenuDataInterface){
        orderingFood.setDrink = drink
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentChoiceSetMenuDialogBinding.inflate(inflater, container, false)


        return binding.root
    }

    fun updateCountText(){
        var setDessertCount = 0
        var setDrinkCount = 0
        if(orderingFood.setDessert !=null){
            setDessertCount = 1
        }
        if (orderingFood.setDrink !=null){
            setDrinkCount = 1
        }
        binding.selectCountText.text = ((setDessertCount.toInt()+setDrinkCount.toInt()).toString())
        binding.remainedCountText.text = (2 - (setDessertCount+setDrinkCount)).toString()
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

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        //카테고리 뷰페이저
        binding.SetMenuChoiceCategory.adapter = SetMenuChoiceCategoryAdapter(this)
        var currentCategory = binding.SetMenuChoiceCategory.currentItem
        binding.SetMenuChoiceCategory.isUserInputEnabled = false;

        binding.SetMenuChoiceMainViewPager.adapter = SetMenuChoiceMainViewPagerAdapter(this)
        binding.SetMenuChoiceMainViewPager.isUserInputEnabled = false;

        var setDessertCount = 0
        var setDrinkCount = 0
        if(orderingFood.setDessert !=null){
            setDessertCount = 1
        }
        if (orderingFood.setDrink !=null){
            setDrinkCount = 1
        }
        binding.selectCountText.text = ((setDessertCount.toInt()+setDrinkCount.toInt()).toString())
        binding.remainedCountText.text = (2 - (setDessertCount+setDrinkCount)).toString()


        binding.cancelButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.paymentButton.setOnClickListener {
            if (orderingFood.setDessert == null || orderingFood.setDrink == null) {
                // "세트 메뉴를 2개 선택해주세요" 토스트 메시지를 표시
                Toast.makeText(requireContext(), "세트 메뉴를 2개 선택해주세요", Toast.LENGTH_SHORT).show()
            } else {
                var isSame = false

                Log.d("addOnlyBurger",FastFoodModel.foodSelectedList.toString())
                applySetPay()

                for (i in 0..FastFoodModel.foodSelectedList.size-1){
                    Log.d("addOnlyBurger food name",FastFoodModel.foodSelectedList[i].food.name.toString())
                    Log.d("addOnlyBurger ordering food name",orderingFood.food.name.toString())

                    Log.d("addOnlyBurger food totalPrice",FastFoodModel.foodSelectedList[i].totalPrice.toString())
                    Log.d("addOnlyBurger ordering food totalPrice",orderingFood.totalPrice.toString())

                    Log.d("addOnlyBurger ordering food totalPrice",orderingFood.toString())


                    if(FastFoodModel.foodSelectedList[i].food.name == orderingFood.food.name && FastFoodModel.foodSelectedList[i].totalPrice == orderingFood.totalPrice){
                        isSame = true
                        FastFoodModel.foodSelectedList[i].foodCount++
                    }
                }

                if (!isSame){
                    FastFoodModel.foodSelectedList.add(orderingFood)
                }

                Log.d(Tag,FastFoodModel.foodSelectedList.toString())



                Log.d("FastfoodModel.foodSelectedList","FastfoodModel.foodSelectedList=${FastFoodModel.foodSelectedList}")

                Log.d("세트 메뉴 선택완료 CALLED","세트 메뉴 선택완료 CALLED")



                viewModel.orderListChanged()
                Log.d(Tag,FastFoodModel.foodSelectedList.toString())

                requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
                requireActivity().supportFragmentManager.popBackStack()

                ApplyFoodOrderList(FastFoodModel.currentActivity).foodAdded()

            }
        }


        var i=0
        viewModel.setMenuSelectedLiveData.observe(this, Observer {
            if(i>0){
                Log.d(Tag,"setMenuSelectedLiveData observed")
//                foodOptionFragmentManage()
            }
            i++
        })

        viewModel.foodSelectedLiveData

        viewModel.setMenuCategoryLiveData.observe(this, Observer{
            when(it){
                "setDessert" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                "setDrink" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }else ->{

            }
            }
        })

        //음식 추가 및 빼기

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

    private fun applySetPay(){
        Log.d("orderingFood.food.price",orderingFood.food.price.toString())
        Log.d("orderingFood.setDessert.price",orderingFood.setDessert!!.price.toString())
        Log.d("orderingFood.setDrink.price",orderingFood.setDrink!!.price.toString())

        var payment : Int = (orderingFood.food.price + orderingFood.setDessert!!.price + orderingFood.setDrink!!.price ) * orderingFood.foodCount
        orderingFood.totalPrice = payment
        Log.d("setMenu applyPay 여기 제대로 됨",orderingFood.totalPrice.toString())
        Log.d("setMenu applyPay 여기 제대로 됨",orderingFood.toString())

    }

}
