package com.example.hyoja.fastfoods

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.Adapter.MyAdapter
import com.example.hyoja.Fragments.dessert
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.hamburger
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.databinding.ActivityFastfoodTab1Binding

class TabActivity : AppCompatActivity(){

    lateinit var binding: ActivityFastfoodTab1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFastfoodTab1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentsList = arrayListOf(lunch(),hamburger(),dessert(),drink())

        binding.apply {
            viewPager.adapter = MyAdapter(fragmentsList, this@TabActivity.supportFragmentManager,lifecycle)
            Log.d("binding.apply: ","bindingApply")
        }


    }
}