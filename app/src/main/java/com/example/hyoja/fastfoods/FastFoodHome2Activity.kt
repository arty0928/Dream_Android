package com.example.hyoja.fastfoods

//import com.example.hyoja.Adapter.MyAdapter
import android.os.Bundle
import android.util.Log
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
import com.example.hyoja.Fragments.dessert
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityBodySetmenuBinding
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding


class FastFoodHome2Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHome2Binding
    val common = CommonUi()

    private lateinit var viewPager: ViewPager2

    //        selectedItems scrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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


