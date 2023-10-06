package com.example.hyoja.cafe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.Adapter.NewCafeAdapter
import com.example.hyoja.Fragments.ade
import com.example.hyoja.Fragments.shake_apogato
import com.example.hyoja.Fragments.coffee
import com.example.hyoja.Fragments.new_menu
import com.example.hyoja.databinding.ActivityCafeNewtabBinding
import com.google.android.material.tabs.TabLayoutMediator

class CafeNewTabActivity : AppCompatActivity(){
    lateinit var binding: ActivityCafeNewtabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCafeNewtabBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = arrayListOf(new_menu(),coffee(),ade(),shake_apogato())
        Log.d("NewTab","NewTab")

        binding.apply {
            newViewPager.adapter= NewCafeAdapter(fragmentList, this@CafeNewTabActivity.supportFragmentManager,lifecycle)

            TabLayoutMediator(newTabLayout,newViewPager){tab, position ->
                when(position){
                    0->tab.text = "신메뉴"
                    1->tab.text = "커피"
                    2->tab.text = "에이드"
                    3->tab.text = "쉐이크&아포가토"
                }

            }.attach()

        }
    }
}