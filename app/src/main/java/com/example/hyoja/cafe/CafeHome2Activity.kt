package com.example.hyoja.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Fragments.shake_apogato
import com.example.hyoja.Fragments.coffee
import com.example.hyoja.Fragments.ade
import com.example.hyoja.Fragments.new_menu
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCafeHome2Binding
class CafeHome2Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityCafeHome2Binding
    val common = CommonUi()

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCafeHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this
//        binding.newbutton.setOnClickListener {
//            common.goToTabTest(view)
//        }


//        HorizontalScrollView 오른쪽 버튼 눌렀을때
        setContentView(R.layout.activity_cafe_home2)
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
            new_menu(),
            coffee(),
            ade(),
            shake_apogato()
        )

        val adapter = CafeAdapterCustome(this, fragments)
        viewPager.adapter = adapter



        //TabView Visible
        val newmenuView = findViewById<View>(R.id.newmenuView)
        val titleNewmenu = findViewById<TextView>(R.id.TitleNewmenu)
        val titleCoffee = findViewById<TextView>(R.id.TitleCoffee)
        val coffeeView = findViewById<View>(R.id.coffeeView)
        val titleAde = findViewById<TextView>(R.id.TitleAde)
        val adeView = findViewById<View>(R.id.AdeView)
        val titleShaApo = findViewById<TextView>(R.id.TitleShaApo)
        val shaApoView = findViewById<View>(R.id.ShaApoView)

        var currentlyVisibleView = newmenuView


        fun toggleVisibility(viewToShow: View) {
            if (currentlyVisibleView != viewToShow) {
                currentlyVisibleView.visibility = View.INVISIBLE
                viewToShow.visibility = View.VISIBLE
                currentlyVisibleView = viewToShow
            }
        }

        titleNewmenu.setOnClickListener {
            viewPager.currentItem = 0
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            toggleVisibility(newmenuView)
        }

        titleCoffee.setOnClickListener {
            viewPager.currentItem = 1
            toggleVisibility(coffeeView)
        }

        titleAde.setOnClickListener {
            viewPager.currentItem = 2
            toggleVisibility(adeView)
        }

        titleShaApo.setOnClickListener {
            viewPager.currentItem = 3
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(scrollAmount,0)
            toggleVisibility(shaApoView)

        }




    }
    class CafeAdapterCustome(
        fragmentActivity: FragmentActivity,
        private val fragments: List<Fragment>) :
        FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}
