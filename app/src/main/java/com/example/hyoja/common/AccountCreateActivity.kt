package com.example.hyoja.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityAccountCreateBinding

class AccountCreateActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountCreateBinding
    val commonUi = CommonUi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.accountStartButton.setOnClickListener{
            commonUi.goToHome(view)
        }
    }
}