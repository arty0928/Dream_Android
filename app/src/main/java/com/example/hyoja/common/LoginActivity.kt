package com.example.hyoja.common

import android.os.Bundle
import android.util.Log
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

        RetrofitUtil().userList()
    }
}