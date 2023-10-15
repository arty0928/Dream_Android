 package com.example.hyoja.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Adapter.SetMenuMyAdapter
import com.example.hyoja.R
import com.example.hyoja.fastfoods.FastFoodHome2Activity
import com.example.hyoja.setMenu1Fragment
import com.example.hyoja.setMenu2Fragment


 class hamburger : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_hamburger, container, false)
//        val setMenuView = inflater.inflate(R.layout.dialog_show_set_or_one, container, false)



        rootView.findViewById<View>(R.id.burger1).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger1)
        }

        rootView.findViewById<View>(R.id.burger2).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger2)
        }

        rootView.findViewById<View>(R.id.burger3).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger3)
        }

        rootView.findViewById<View>(R.id.burger4).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger4)
        }

        rootView.findViewById<View>(R.id.burger5).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger5)
        }

        rootView.findViewById<View>(R.id.burger6).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger6)
        }

        return rootView
    }

     private fun getBurgerPrice(imageResId: Int): String {
         return when (imageResId) {
             R.drawable.burger1 -> "4,400"
             R.drawable.burger2 -> "3,500"
             R.drawable.burger3 -> "4,500"
             R.drawable.burger4 -> "4,600"
             R.drawable.burger5 -> "5,500"
             R.drawable.burger6 -> "4,400"
             else -> "가격 정보 없음"
         }
     }

     private fun getSetPrice(imageResId: Int): String {
         return when (imageResId) {
             R.drawable.burger1 -> "6,400"
             R.drawable.burger2 -> "5,500"
             R.drawable.burger3 -> "6,500"
             R.drawable.burger4 -> "6,600"
             R.drawable.burger5 -> "7,500"
             R.drawable.burger6 -> "6,400"
             else -> "가격 정보 없음"
         }
     }

    private fun showBurgerDetailsDialog(imageResId: Int) {

        val dialogView = layoutInflater.inflate(R.layout.dialog_show_set_or_one, null)
        dialogView.setBackgroundColor(Color.TRANSPARENT);

//         다이얼로그 뷰에 내용 설정
//        dialogView.setImageResource(imageResId)
//        dialogView.dialog_burger_name.text = burgerName
//        dialogView.dialog_burger_price.text = "가격: $burgerPrice"

//        다이얼로그 가격 설정
        val burgerPrice = getBurgerPrice(imageResId) // 선택한 버거에 따른 가격을 가져오는 함수 호출
        val onlyBurgerPriceTextView = dialogView.findViewById<TextView>(R.id.only_burger_price)
        val setBurgerPriceTextView = dialogView.findViewById<TextView>(R.id.set_price)

        onlyBurgerPriceTextView.text = burgerPrice
        setBurgerPriceTextView.text = getSetPrice(imageResId)

//        다이얼로그 이미지 설정
        val onlyBurgerImageView = dialogView.findViewById<ImageView>(R.id.only_burger_image)
        val setBurgerImageView = dialogView.findViewById<ImageView>(R.id.set_image)
        onlyBurgerImageView.setImageResource(imageResId)
        setBurgerImageView.setImageResource(imageResId)


        // AlertDialog를 생성하고 설정
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(dialogView)

        // 다이얼로그를 표시
        val alertDialog = alertDialogBuilder.create()

        // 다이얼로그 외부를 터치해도 닫히지 않도록 설정
        alertDialog.setCanceledOnTouchOutside(false)

        // "X" 버튼 클릭 시 다이얼로그 닫기
        val closeButton = dialogView.findViewById<ImageView>(R.id.dialog_x_button)
        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }

        val onlyBurger = dialogView.findViewById<GridLayout>(R.id.only_burger_grid)
        onlyBurger.setOnClickListener {
            alertDialog.dismiss()
        }

        val setBurger = dialogView.findViewById<GridLayout>(R.id.set_grid)
        setBurger.setOnClickListener {
            alertDialog.dismiss()
            Log.d("burger","burger button")
            showSetMenuChoiceDialog(imageResId)
        }

        alertDialog.show()
    }

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