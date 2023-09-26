package com.example.hyoja.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCafeHome2Binding

class CafeHome2Activity:AppCompatActivity() {
    var backPressedTime: Long =0
    private lateinit var binding: ActivityCafeHome2Binding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this
    }

}