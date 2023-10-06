package com.example.hyoja.cafe

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.Adapter.CafeAdapter
import com.example.hyoja.Fragments.ade
import com.example.hyoja.Fragments.shake_apogato
import com.example.hyoja.Fragments.coffee
import com.example.hyoja.Fragments.new_menu
import com.example.hyoja.databinding.ActivityCafeTab1Binding

class CafeTabActivity : AppCompatActivity(){

    lateinit var binding: ActivityCafeTab1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCafeTab1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentsList = arrayListOf(new_menu(),coffee(),ade(),shake_apogato())

        binding.apply {
            viewPager.adapter = CafeAdapter(fragmentsList, this@CafeTabActivity.supportFragmentManager,lifecycle)
            Log.d("binding.apply: ","bindingApply")
        }


    }
}