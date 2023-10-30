 package com.example.hyoja.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Adapter.SetMenuMyAdapter
import com.example.hyoja.R
import com.example.hyoja.databinding.FragmentFoodListNewMenuOneBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.FoodDataInterface
import com.example.hyoja.fastfoods.util.FoodDataFactory
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel
import com.example.hyoja.setMenu1Fragment
import com.example.hyoja.setMenu2Fragment


 class FoodListMenuOneFrament : Fragment() {
     private val Tag: String = "FoodListNewMenuOneFragment"
     lateinit var binding : FragmentFoodListNewMenuOneBinding
     //현재 선택한 카테고리의 음료리스트
     private lateinit var foodArayList : ArrayList<FoodDataInterface>

     //뷰모델
     private lateinit var viewModel: FoodListViewModel

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         //뷰모델 프로바이더 생성
         viewModel = ViewModelProvider(requireActivity())[FoodListViewModel::class.java]

         viewModel.categoryLiveData.observe(requireActivity(), Observer{
             getFoodArrayList(it)
             setUI()
         })

         //버튼 리스너
         binding.burger1.setOnClickListener{
             callOrderFood(foodArayList[0])
         }
         binding.burger2.setOnClickListener{
             callOrderFood(foodArayList[1])
         }
         binding.burger3.setOnClickListener{
             callOrderFood(foodArayList[2])
         }
         binding.burger4.setOnClickListener{
             callOrderFood(foodArayList[3])
         }
         binding.burger5.setOnClickListener{
             callOrderFood(foodArayList[4])
         }
         binding.burger6.setOnClickListener{
             callOrderFood(foodArayList[5])
         }
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListNewMenuOneBinding.inflate(inflater,container,false)

        //맨 처음 oncreate상황에서는 newMenu 받아와야함
        //현재 보여질 음료 카테고리 리스트를 newMenu로 설정
        //받아온 정보를 통해 UI세팅
        val foodData = FoodDataFactory()
        foodArayList = foodData.getNewMenuArrayList()
        setUI()

        return binding.root

//        rootView.findViewById<View>(R.id.burger6).setOnClickListener {
//            showBurgerDetailsDialog(R.drawable.burger6)
//        }

    }

    private fun getFoodArrayList(category:String){
        val foodData = FoodDataFactory()

        when(category){
            "newMenu" -> {
                foodArayList = foodData.getNewMenuArrayList()
            }
            "hamburger" -> {
                foodArayList = foodData.getHamburgerArrayList()
            }
            "dessert" -> {
                foodArayList = foodData.getDessertArrayList()
            }
            "drink" -> {
                foodArayList = foodData.getDrinkArrayList()
            }
        }
    }

     override fun onResume() {
         super.onResume()
         Log.d("resume","called")
         binding.root.requestLayout()
     }

     private fun setUI(){
         setButtonUI1(foodArayList[0])
         setButtonUI2(foodArayList[1])
         setButtonUI3(foodArayList[2])
         setButtonUI4(foodArayList[3])
         setButtonUI5(foodArayList[4])
         setButtonUI6(foodArayList[5])
     }

     //버튼 UI 세팅
     private fun setButtonUI1(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger1Image.setImageResource(foodData.foodImage)
         binding.burger1Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger1Price.text = ""
             binding.burger1Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger1Price.text = foodData.price.toString()
         }
     }

     private fun setButtonUI2(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger2Image.setImageResource(foodData.foodImage)
         binding.burger2Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger2Price.text = ""
             binding.burger2Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger2Price.text = foodData.price.toString()
         }
     }

     private fun setButtonUI3(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger3Image.setImageResource(foodData.foodImage)
         binding.burger3Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger3Price.text = ""
             binding.burger3Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger3Price.text = foodData.price.toString()
         }
     }

     private fun setButtonUI4(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger4Image.setImageResource(foodData.foodImage)
         binding.burger4Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger4Price.text = ""
             binding.burger4Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger4Price.text = foodData.price.toString()
         }
     }

     private fun setButtonUI5(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger5Image.setImageResource(foodData.foodImage)
         binding.burger5Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger5Price.text = ""
             binding.burger5Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger5Price.text = foodData.price.toString()
         }
     }

     private fun setButtonUI6(foodData: FoodDataInterface){
         //이미지와 이름 세팅
         binding.burger6Image.setImageResource(foodData.foodImage)
         binding.burger6Name.text = foodData.name
         //밑의 가격표
         if(foodData.category == "ready"){
             // 준비 중 데이터면 아예 안 보이게 설정
             binding.burger6Price.text = ""
             binding.burger6Image.setImageResource(foodData.foodImage)
         }
         else{
             binding.burger6Price.text = foodData.price.toString()
         }
     }

     private fun callOrderFood(foodData: FoodDataInterface){
         if (foodData.category != "ready"){
             FastFoodModel.foodSelected = foodData
             viewModel.foodSelectChanged()
             Log.d(Tag,"foodSelected= "+ FastFoodModel.foodSelected)
         }
     }

//    private fun showBurgerDetailsDialog(imageResId: Int) {
//
//        val dialogView = layoutInflater.inflate(R.layout.dialog_show_set_or_one, null)
//        dialogView.setBackgroundColor(Color.TRANSPARENT);
//
////         다이얼로그 뷰에 내용 설정
////        dialogView.setImageResource(imageResId)
////        dialogView.dialog_burger_name.text = burgerName
////        dialogView.dialog_burger_price.text = "가격: $burgerPrice"
//
////        다이얼로그 가격 설정
//        val burgerPrice = getBurgerPrice(imageResId) // 선택한 버거에 따른 가격을 가져오는 함수 호출
//        val onlyBurgerPriceTextView = dialogView.findViewById<TextView>(R.id.only_burger_price)
//        val setBurgerPriceTextView = dialogView.findViewById<TextView>(R.id.set_price)
//
//        onlyBurgerPriceTextView.text = burgerPrice
//        setBurgerPriceTextView.text = getSetPrice(imageResId)
//
////        다이얼로그 이미지 설정
//        val onlyBurgerImageView = dialogView.findViewById<ImageView>(R.id.only_burger_image)
//        val setBurgerImageView = dialogView.findViewById<ImageView>(R.id.set_image)
//        onlyBurgerImageView.setImageResource(imageResId)
//        setBurgerImageView.setImageResource(imageResId)
//
//
//        // AlertDialog를 생성하고 설정
//        val alertDialogBuilder = AlertDialog.Builder(requireContext())
//        alertDialogBuilder.setView(dialogView)
//
//        // 다이얼로그를 표시
//        val alertDialog = alertDialogBuilder.create()
//
//        // 다이얼로그 외부를 터치해도 닫히지 않도록 설정
//        alertDialog.setCanceledOnTouchOutside(false)
//
//        // "X" 버튼 클릭 시 다이얼로그 닫기
//        val closeButton = dialogView.findViewById<ImageView>(R.id.dialog_x_button)
//        closeButton.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//        val onlyBurger = dialogView.findViewById<GridLayout>(R.id.only_burger_grid)
//        onlyBurger.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//        val setBurger = dialogView.findViewById<GridLayout>(R.id.set_grid)
//        setBurger.setOnClickListener {
//            alertDialog.dismiss()
//            Log.d("burger","burger button")
//            showSetMenuChoiceDialog(imageResId)
//        }
//
//        alertDialog.show()
//    }

    @SuppressLint("MissingInflatedId")
    private fun showSetMenuChoiceDialog(imageResId: Int){

        lateinit var viewPager: ViewPager2

        val dialogView = layoutInflater.inflate(R.layout.dialog_set_menu_choice, null)
        dialogView.setBackgroundColor(Color.TRANSPARENT);

        // AlertDialog를 생성하고 설정
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(dialogView)

        // 다이얼로그를 표시
        val alertDialog = alertDialogBuilder.create()

        val cancalButton = dialogView.findViewById<View>(R.id.setmenu_cancel_button)
        cancalButton.setOnClickListener {
            alertDialog.dismiss()
        }

        viewPager = dialogView.findViewById(R.id.viewPager)
        viewPager.isUserInputEnabled = false

        val fragments = listOf(
            setMenu1Fragment(),
            setMenu2Fragment()
        )

        val adapter = SetMenuMyAdapter(this,fragments)
        viewPager.adapter = adapter

        val horizontalScrollView = dialogView.findViewById<HorizontalScrollView>(R.id.TabBarTitleHorizontalScroll_setmenu)
        val tabTitleLeftBtn_setmenu = dialogView.findViewById<ImageView>(R.id.TabTitleLeftBtn_setmenu)
        val tabTitleRightBtn_setmenu = dialogView.findViewById<ImageView>(R.id.TabTitleRightBtn_setmenu)

        tabTitleLeftBtn_setmenu.setOnClickListener {
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount, 0)
            Log.d("TabTitleLeftBtn_setmenu", "TabTitleLeftBtn_setmenu")
        }

        tabTitleRightBtn_setmenu.setOnClickListener {
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(scrollAmount, 0)
            Log.d("TabTitleLeftBtn_setmenu", "TabTitleLeftBtn_setmenu")
        }

        //TabView Visible
        val setDessertSetMenu = dialogView.findViewById<View>(R.id.set_dessert)
        val setDrinkSetMenu = dialogView.findViewById<View>(R.id.set_drink)
        val setDessertTitle = dialogView.findViewById<View>(R.id.set_dessert_title)
        val setDrinkTitle = dialogView.findViewById<View>(R.id.set_drink_title)

        var currentlyVisibleView = setDessertSetMenu


        fun toggleVisibility(viewToShow: View) {
            if (currentlyVisibleView != viewToShow) {
                currentlyVisibleView.visibility = View.INVISIBLE
                viewToShow.visibility = View.VISIBLE
                currentlyVisibleView = viewToShow
            }
        }

        setDessertTitle.setOnClickListener {
            viewPager.currentItem = 0
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            toggleVisibility(setDessertSetMenu)
        }

        setDrinkTitle.setOnClickListener {
            viewPager.currentItem = 1
            toggleVisibility(setDrinkSetMenu)
        }


        // 다이얼로그 외부를 터치해도 닫히지 않도록 설정
        alertDialog.setCanceledOnTouchOutside(false)

        alertDialog.show()

    }
}