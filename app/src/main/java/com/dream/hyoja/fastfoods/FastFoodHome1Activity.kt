package com.dream.hyoja.fastfoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dream.hyoja.common.MainActivity
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodHome1Binding
import com.dream.hyoja.fastfoods.model.FastFoodModel

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

        FastFoodModel.foodSelectedList.clear()

        binding.button1.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }

        binding.button2.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }
        binding.button3.setOnClickListener {
            common.goToFastFoodHome1Button1(view)
        }

        binding.FastFoodHome.setOnClickListener {
            common.goToHome(view)
        }
    }
}

