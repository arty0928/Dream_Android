package com.example.hyoja.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityMainBinding

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
    }
    // 뒤로가기 버튼을 눌렀을 때 로직
    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()

        if (currentTime - backPressedTime < 2000) {
            finish()
        } else {
            Toast.makeText(this, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }
}