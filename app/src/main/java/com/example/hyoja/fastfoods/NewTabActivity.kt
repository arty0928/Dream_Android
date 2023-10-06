package com.example.hyoja.fastfoods

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.Adapter.NewMyAdapter
import com.example.hyoja.Fragments.dessert
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.databinding.ActivityFastfoodNewtabBinding
import com.google.android.material.tabs.TabLayoutMediator

class NewTabActivity : AppCompatActivity(){
    lateinit var binding: ActivityFastfoodNewtabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFastfoodNewtabBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = arrayListOf(lunch(),hamburger(),dessert(),drink())
        Log.d("NewTab","NewTab")

        binding.apply {
            newViewPager.adapter= NewMyAdapter(fragmentList, this@NewTabActivity.supportFragmentManager,lifecycle)
            
            TabLayoutMediator(newTabLayout,newViewPager){tab, position ->
                when(position){
                    0->tab.text = "든든점심"
                    1->tab.text = "햄버거"
                    2->tab.text = "디저트/치킨"
                    3->tab.text = "음료수"
                }
                
            }.attach()
            
        }
    }
}