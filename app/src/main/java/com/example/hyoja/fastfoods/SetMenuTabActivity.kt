package com.example.hyoja.fastfoods

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Adapter.NewMyAdapter
import com.example.hyoja.Adapter.SetMenuMyAdapter
import com.example.hyoja.Fragments.dessert
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.R
import com.example.hyoja.databinding.ActivityBodySetmenuBinding
import com.example.hyoja.databinding.ActivityFastfoodNewtabBinding
import com.example.hyoja.databinding.DialogSetMenuChoiceBinding
import com.example.hyoja.setMenu1Fragment
import com.example.hyoja.setMenu2Fragment
import com.google.android.material.tabs.TabLayoutMediator

class SetMenuTabActivity : AppCompatActivity(){

//  private lateinit var binding: DialogSetMenuChoiceBinding
  private lateinit var viewPager: ViewPager2
//
  override fun onCreate(savedInstanceState: Bundle?) {
//    binding = DialogSetMenuChoiceBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
//
    val view = this


    Log.d("SetMenuTabActivity","call")
//
    setContentView(R.layout.dialog_set_menu_choice)
    viewPager = findViewById(R.id.SetmenuViewPager)
    // 스와이프를 비활성화합니다.

   viewPager.isUserInputEnabled = false

    val fragments = listOf(
      setMenu1Fragment(),
      setMenu2Fragment()
    )

    val adapter = SetMenuMyAdapter(this, fragments)
    viewPager.adapter = adapter
//
//    //TabView Visible
//    val lunchView = findViewById<View>(R.id.lunchView_setmenu)
//    val titleLunch = findViewById<TextView>(R.id.TitleLunch_setmenu)
//    val titleHamburger = findViewById<TextView>(R.id.TitleHamburger_setmenu)
//    val hamburgerView = findViewById<View>(R.id.hamburgerView_setmenu)
//
//    var currentlyVisibleView = lunchView
//
//
//    fun toggleVisibility(viewToShow: View) {
//      if (currentlyVisibleView != viewToShow) {
//        currentlyVisibleView.visibility = View.INVISIBLE
//        viewToShow.visibility = View.VISIBLE
//        currentlyVisibleView = viewToShow
//      }
//    }
//
//    titleLunch.setOnClickListener {
//      viewPager.currentItem = 0
//      val scrollAmount = 300
//      toggleVisibility(lunchView)
//    }
//
//    titleHamburger.setOnClickListener {
//      viewPager.currentItem = 1
//      toggleVisibility(hamburgerView)
//    }
//
  }
}