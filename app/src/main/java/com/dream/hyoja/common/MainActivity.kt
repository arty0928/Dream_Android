package com.dream.hyoja.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding :ActivityMainBinding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.cafeButton.setOnClickListener {
            common.goToCafe(view)
        }
        binding.fastfoodButton.setOnClickListener {
            common.goToFastFood(view)
        }

        //카페 설명서 버튼
        binding.cafePrcBtn.setOnClickListener {
            common.goToCafeStartEx(view)
        }

        binding.fastfoodPrcBtn.setOnClickListener {

        }

        //로고 누르면 홈으로
        binding.hyojaLogo.setOnClickListener {
            common.goToLogin(view)
        }

        binding.hyojaText.setOnClickListener {
            common.goToLogin(view)
        }
    }
    // 뒤로가기 버튼을 눌렀을 때 로직
    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()

        if (currentTime - backPressedTime < 2000) {
            ActivityCompat.finishAffinity(this)
            System.exit(0)
        } else {
            Toast.makeText(this, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }
}