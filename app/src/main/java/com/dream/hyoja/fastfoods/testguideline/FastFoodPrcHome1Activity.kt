package com.dream.hyoja.fastfoods.testguideline

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dream.hyoja.R
import com.dream.hyoja.common.MainActivity
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodHome1Binding
import com.dream.hyoja.databinding.ActivityFastfoodPrcHome1Binding
import com.dream.hyoja.fastfoods.model.FastFoodModel

class FastFoodPrcHome1Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodPrcHome1Binding
    val common = CommonUi()
    val main = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodPrcHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        FastFoodModel.foodSelectedList.clear()

        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.startOrderWithCard.startAnimation(anim)

        binding.startOrderWithCard.setOnClickListener {
//            common.goToFastFoodHome1Button1(view)
        }
    }
    override fun onBackPressed() {
        // 뒤로가기 막기
        val currentTime = System.currentTimeMillis()
        val commonUi:CommonUi = CommonUi()
        val view = this

        if (currentTime - backPressedTime < 2000) {
            commonUi.goToHome(view)
            finish()
        } else {
            Toast.makeText(this, "한 번 더 누르면 메인화면으로 전환합니다", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }
}

