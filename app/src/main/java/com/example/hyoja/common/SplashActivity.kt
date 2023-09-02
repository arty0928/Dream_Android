package com.example.hyoja.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi

class SplashActivity : AppCompatActivity() {
    val commonUi = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val view = this
        Handler().postDelayed({ // 스플래시 1초 후 홈화면으로
            commonUi.goToHome(view)
            finish() // 스플래시는 꼭 종료시켜 주세요
        }, 1000)


    }


}