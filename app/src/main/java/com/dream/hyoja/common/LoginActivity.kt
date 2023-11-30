package com.dream.hyoja.common

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding :ActivityLoginBinding
    val commonUi = CommonUi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.accountCreateButton.setOnClickListener{
            commonUi.goToAccountCreate(view)
            finish() // 다시 돌아오지 못하게 종료해주세요
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