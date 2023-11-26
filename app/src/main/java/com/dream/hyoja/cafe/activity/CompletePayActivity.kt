package com.dream.hyoja.cafe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityCompletePayBinding

class CompletePayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCompletePayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setOnClickListener{
            CommonUi().goToCafe(this)
        }
    }

    private var backPressedTime:Long = 0
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