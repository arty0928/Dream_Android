package com.example.hyoja.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.common.MainActivity
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCafeHome1Binding

class CafeHome1Activity : AppCompatActivity() {
    var backPressedTime: Long = 0
    private lateinit var binding: ActivityCafeHome1Binding
    val common = CommonUi()
    val main = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.coffee.setOnClickListener{
            common.goToCafeHome1coffee(view)
        }
}
}

