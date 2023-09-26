package com.example.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
//import com.example.hyoja.Adapter.MyAdapter
import com.example.hyoja.Fragments.dessert
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding

class FastFoodHome2Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHome2Binding
    val common = CommonUi()

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
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

        val fragments = listOf(
            lunch(),
            hamburger(),
            dessert(),
            drink()
        )

        val adapter = MyAdapterCustome(this, fragments)
        viewPager.adapter = adapter

        val titleLunch = findViewById<TextView>(R.id.TitleLunch)
        titleLunch.setOnClickListener {
            viewPager.currentItem = 0
        }
        val titleHamburger = findViewById<TextView>(R.id.TitleHamburger)
        titleHamburger.setOnClickListener {
            viewPager.currentItem = 1
        }

        val titleDessert = findViewById<TextView>(R.id.TitleDessert)
        titleDessert.setOnClickListener {
            viewPager.currentItem = 2
        }

        val titleDrink = findViewById<TextView>(R.id.TitleDrink)
        titleDrink.setOnClickListener {
            viewPager.currentItem = 3
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
