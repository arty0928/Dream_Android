package com.example.hyoja.fastfoods

//import com.example.hyoja.Adapter.MyAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding

// TRUE 면 세트
data class MenuItem(
    val name: String,
    val imageResId: Int,
    val price: Int,
    val isSet: Boolean = false,
    val setMenu: List<MenuItem>? = null
)


object MenuRepository {
    private val menuList = mutableListOf<MenuItem>()

    // 메뉴 항목을 추가하는 함수
    fun addMenuItem(menuItem: MenuItem) {
        menuList.add(menuItem)
    }

    // 전체 메뉴 목록을 반환하는 함수
    fun getAllMenuItems(): List<MenuItem> {
        return menuList
    }
}


class FastFoodHome2Activity : AppCompatActivity(){
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    lateinit var binding: ActivityFastfoodHome2Binding
    val common = CommonUi()

    lateinit var viewPager: ViewPager2

    //        selectedItems scrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // 메뉴 선택 시 화면에 메뉴 추가
        fun menuSelected(menuItem: MenuItem) {
            val addedMenu = MenuRepository.getAllMenuItems()
            val selectedItemsLayout = binding.selectedItems
            val inflater = LayoutInflater.from(this)

            for (addedMenuItem in addedMenu) {
                val selectedMenuLayout = inflater.inflate(R.layout.selected_menu, null)

                // 메뉴 이름 설정
                val itemNameTextView = selectedMenuLayout.findViewById<TextView>(R.id.selectedItemName)
                itemNameTextView.text = addedMenuItem.name

                // 메뉴 가격 설정
                val itemPriceTextView = selectedMenuLayout.findViewById<TextView>(R.id.selectedItemPrice)
                itemPriceTextView.text = addedMenuItem.price.toString()

                // 나머지 요소 업데이트 및 이벤트 처리

                selectedItemsLayout.addView(selectedMenuLayout)
            }
        }




        val view = this

//        HorizontalScrollView 오른쪽 버튼 눌렀을때
        setContentView(R.layout.activity_fastfood_home2)
        val tabTitleRightBtn = findViewById<ImageView>(R.id.TabTitleRightBtn)
        val horizontalScrollView = findViewById<HorizontalScrollView>(R.id.TabBarTitleHorizontalScroll)

        tabTitleRightBtn.setOnClickListener{
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }

//        HorizontalScrollView 왼쪽 버튼 눌렀을때
        val tabTitleLeftBtn = findViewById<ImageView>(R.id.TabTitleLeftBtn)
        tabTitleLeftBtn.setOnClickListener{
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }

        viewPager = findViewById(R.id.viewPager)

        // 스와이프를 비활성화합니다.
        viewPager.isUserInputEnabled = false

        val fragments = listOf(
            lunch(),
            hamburger(),
            dessert(),
            drink()
        )

        val adapter = MyAdapterCustome(this, fragments)
        viewPager.adapter = adapter

        //TabView Visible
        val lunchView = findViewById<View>(R.id.lunchView)
        val titleLunch = findViewById<TextView>(R.id.TitleLunch)
        val titleHamburger = findViewById<TextView>(R.id.TitleHamburger)
        val hamburgerView = findViewById<View>(R.id.hamburgerView)
        val titleDessert = findViewById<TextView>(R.id.TitleDessert)
        val dessertView = findViewById<View>(R.id.DessertView)
        val titleDrink = findViewById<TextView>(R.id.TitleDrink)
        val drinkView = findViewById<View>(R.id.DrinkView)

        var currentlyVisibleView = lunchView


        fun toggleVisibility(viewToShow: View) {
            if (currentlyVisibleView != viewToShow) {
                currentlyVisibleView.visibility = View.INVISIBLE
                viewToShow.visibility = View.VISIBLE
                currentlyVisibleView = viewToShow
            }
        }

        titleLunch.setOnClickListener {
            viewPager.currentItem = 0
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            toggleVisibility(lunchView)
        }

        titleHamburger.setOnClickListener {
            viewPager.currentItem = 1
            toggleVisibility(hamburgerView)
        }

        titleDessert.setOnClickListener {
            viewPager.currentItem = 2
            toggleVisibility(dessertView)
        }

        titleDrink.setOnClickListener {
            viewPager.currentItem = 3
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(scrollAmount,0)
            toggleVisibility(drinkView)

        }

        //selectedItems scrollView
        val nestedScrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)
        val upButton = findViewById<View>(R.id.upButton)
        val downButton = findViewById<View>(R.id.downButton)

        upButton.setOnClickListener {
            nestedScrollView.smoothScrollBy(0, -200) // Adjust the scroll amount as needed
        }

        downButton.setOnClickListener {
            nestedScrollView.smoothScrollBy(0, 200) // Adjust the scroll amount as needed
        }



    }

    class MyAdapterCustome(
        fragmentActivity: FragmentActivity,
        private val fragments: List<Fragment>) :
        FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }

}


