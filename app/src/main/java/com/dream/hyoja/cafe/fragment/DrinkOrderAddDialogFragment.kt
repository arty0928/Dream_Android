package com.dream.hyoja.cafe.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.R
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.model.OrderingDrink
import com.dream.hyoja.cafe.util.ApplyOrderList
import com.dream.hyoja.cafe.viewmodel.MenuListViewModel
import com.dream.hyoja.common.SplashActivity
import com.dream.hyoja.common.util.ManualStepChecker
import com.dream.hyoja.databinding.FragmentDrinkOrderAddBinding

class DrinkOrderAddDialogFragment: DialogFragment() {
    private val Tag:String = "DrinkOrderAddDialogFragment"
    lateinit var binding: FragmentDrinkOrderAddBinding
    private lateinit var viewModel: MenuListViewModel

    private val selectedDrinkItem = CafeModel.drinkSelected

    private val freeOption:ArrayList<String> = ArrayList()
    private val option:ArrayList<String> = ArrayList()
    private val orderingDrink:OrderingDrink = OrderingDrink(
        // 처음 온도를 정할 수 있는 경우 Hot
        // 온도가 정해져 있는 경우 defaultDegree
        degree =
        if (CafeModel.drinkSelected.defaultDegree == "selectable") {
            "Hot"
        } else {
            CafeModel.drinkSelected.defaultDegree
        }.toString(),
        freeOption = freeOption,
        option = option,
        drink = CafeModel.drinkSelected
    )

    fun getOrderingDrink():OrderingDrink{
        return orderingDrink
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //뷰모델 프로바이더
        viewModel = ViewModelProvider(this)[MenuListViewModel::class.java]

        //선택 완료 버튼
        binding.selectCompleteButton.setOnClickListener {
            // 장바구니에 현재 고르고 있는 음료 추가
            CafeModel.drinkSelectedList.add(orderingDrink)
            //
            viewModel.orderListChanged()
            for(i in 0 until CafeModel.drinkSelectedList.size){
                Log.d(Tag,CafeModel.drinkSelectedList[i].toString())
            }
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()

            // 액티비티로 콜백 전달
            ApplyOrderList(CafeModel.currentActivity).drinkAdd()
        }

        // 음료 추가 및 빼기
        binding.itemPlus.setOnClickListener{
            addDrinkCount()
        }
        binding.itemMinus.setOnClickListener{
            minusDrinkCount()
        }

        // 음료 사이즈
        binding.regularButton.setOnClickListener {
            regularButtonClicked()
        }
        binding.extraButton.setOnClickListener {
            extraButtonClicked()
        }

        // 음료 온도 선택
        binding.icedButton.setOnClickListener {
            icedButtonClicked()
        }
        binding.hotButton.setOnClickListener {
            hotButtonClicked()
        }

        //취소 버튼
        binding.cancelButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }

        // 유료옵션
        binding.option.setOnClickListener {
            // 프래그먼트 옵션 추가 띄우기
            // 유료옵션은 true
            showOptionFragment(true)
        }

        // 무료옵션
        binding.freeOption.setOnClickListener {
            // 프래그먼트 옵션 추가 띄우기
            // 무료옵션은 true
            showOptionFragment(false)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkOrderAddBinding.inflate(inflater, container, false)
        val view = binding.root
        // 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setUi()
        return view
    }
    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.85).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }

    private fun setUi(){
        // 음료 이미지
        binding.addDrinkImage.setImageResource(orderingDrink.drink.drinkImage)
        // 음료 이름
        binding.drinkName.text = orderingDrink.drink.name
        // 음료 가격
        binding.drinkPrice.text = orderingDrink.drink.price.toString()
        setDegreeUI()
        applyPay()
    }
    private fun setDegreeUI(){
        val degree = orderingDrink.drink.degree
        if (!degree){//false일 때
            binding.hotButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_gray))
            binding.icedButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_gray))
        }
    }
    private fun hotButtonClicked(){
        if(orderingDrink.drink.degree){
            binding.hotButton.setBackgroundResource(R.drawable.hot_button_clicked)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_white))
            binding.icedButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_gray))

            orderingDrink.degree = "Hot"
        }
    }

    private fun icedButtonClicked(){
        if(orderingDrink.drink.degree) {
            binding.hotButton.setBackgroundResource(R.drawable.button_can_not_click)
            binding.hotButton.setTextColor(resources.getColor(R.color.cafe_gray))
            binding.icedButton.setBackgroundResource(R.drawable.iced_button_clicked)
            binding.icedButton.setTextColor(resources.getColor(R.color.cafe_white))

            orderingDrink.degree = "Iced"
        }
    }
    private fun regularButtonClicked(){
        binding.regularButton.setBackgroundResource(R.drawable.hot_button_unclicked)
        binding.extraButton.setBackgroundResource(R.drawable.border_line)
        orderingDrink.size = 0
        applyPay()
    }
    private fun extraButtonClicked(){
        binding.extraButton.setBackgroundResource(R.drawable.hot_button_unclicked)
        binding.regularButton.setBackgroundResource(R.drawable.border_line)
        orderingDrink.size = 1
        applyPay()
    }
    private fun addDrinkCount(){
        orderingDrink.drinkCount++
        binding.itemNum.text = orderingDrink.drinkCount.toString()
        applyPay()
    }
    private fun minusDrinkCount(){
        if (orderingDrink.drinkCount>1){
            orderingDrink.drinkCount--
            binding.itemNum.text = orderingDrink.drinkCount.toString()
            applyPay()
        }

    }
    fun applyPay(){
        var payment: Int = (orderingDrink.shot*500 + orderingDrink.drink.price + 500 * orderingDrink.size) * orderingDrink.drinkCount
        orderingDrink.price = payment
        binding.drinkPrice.text = orderingDrink.price.toString()
    }

    private fun showOptionFragment(optionInfo: Boolean){
        val optionAddFragment = OptionAddFragment()
        val freeOptionAddFragment = FreeOptionAddFragment()

        if(optionInfo){
            optionAddFragment.setOrderingDrink(orderingDrink)
            optionAddFragment.setParentFragment(this)
            optionAddFragment.show(
                childFragmentManager,"OptionAddFragment"
            )
        } else{
            freeOptionAddFragment.setOrderingDrink(orderingDrink)
            freeOptionAddFragment.show(
                childFragmentManager,"FreeOptionAddFragment"
            )
        }
    }
}