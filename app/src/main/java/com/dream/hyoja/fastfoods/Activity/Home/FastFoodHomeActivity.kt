package com.dream.hyoja.fastfoods.Activity.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.dream.hyoja.R
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodHomeBinding

class FastFoodHomeActivity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHomeBinding
    val common = CommonUi()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.HomeImage.startAnimation(anim)

        binding.fastfoodToHome1Button.setOnClickListener{
            common.goToFastFoodHome1(view)
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