package com.example.hyoja.fastfoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.common.MainActivity
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodHome1Binding
import com.example.hyoja.databinding.ActivityFastfoodHomeBinding

class FastFoodHome1Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHome1Binding
    val common = CommonUi()
    val main = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.button1.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }

        binding.button2.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }
        binding.button3.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }
        binding.beforeButton.setOnClickListener {
//            main.backPressedTime()
        }
    }
}

