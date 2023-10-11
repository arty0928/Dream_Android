package com.example.hyoja.cafe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.Adapter.NewCafeAdapter
import com.example.hyoja.Fragments.ade
import com.example.hyoja.Fragments.shake_apogato
import com.example.hyoja.Fragments.coffee
import com.example.hyoja.Fragments.coffee1
import com.example.hyoja.Fragments.new_menu
import com.example.hyoja.databinding.ActivityCafeNewtabBinding
import com.example.hyoja.databinding.ActivityCafeHome2Binding
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.ImageView
import com.example.hyoja.R

class CafeNewTabActivity : AppCompatActivity(){
    lateinit var binding: ActivityCafeNewtabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCafeNewtabBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bindingHome2: ActivityCafeHome2Binding = ActivityCafeHome2Binding.inflate(layoutInflater)
        val menuRightBtn: ImageView = bindingHome2.MenuRightBnt
        val menuLeftBtn: ImageView = bindingHome2.MenuLeftBnt


        val allFragmentList = arrayListOf(new_menu(),coffee(), ade(),shake_apogato(), coffee1())
        Log.d("NewTab","NewTab")

        val tabFragmentList = arrayListOf(new_menu(),coffee(), ade(),shake_apogato())



        binding.apply {
            newViewPager.adapter= NewCafeAdapter(allFragmentList, this@CafeNewTabActivity.supportFragmentManager,lifecycle)

            TabLayoutMediator(newTabLayout,newViewPager){tab, position ->
                // 여기서 position은 ViewPager의 페이지 인덱스를 참조하지 않습니다. 대신, tabFragmentList의 인덱스를 참조합니다.
                when(position){
                    0->tab.text = "신메뉴"
                    1->tab.text = "커피"
                    2->tab.text = "에이드"
                    3->tab.text = "쉐이크&아포가토"
                }

            }.attach()

            bindingHome2.MenuRightBnt.setOnClickListener {
                Log.d("ButtonCheck", "Button is Clicked!")
                newViewPager.currentItem = 4  // 커피1 페이지의 인덱스
            }

            }

            }
        }


