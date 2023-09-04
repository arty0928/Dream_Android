package com.example.hyoja.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityLoginBinding

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
}