package com.example.hyoja.common

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.common.model.UserResponse
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.common.util.api.ApiService
import com.example.hyoja.common.util.api.RetrofitUtil
import com.example.hyoja.databinding.ActivityLoginBinding
import com.orhanobut.logger.AndroidLogAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Logger


class LoginActivity : AppCompatActivity() {
    lateinit var binding :ActivityLoginBinding
    val commonUi = CommonUi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.loginButton.setOnClickListener{
            commonUi.goToHome(view)
            finish() // 다시 돌아오지 못하게 종료해주세요
        }

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