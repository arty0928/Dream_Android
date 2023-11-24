package com.example.hyoja.common

import android.content.Context
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

        // 임시
        val sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()
        commonUi.goToHome(this)

        val view = this
        Handler().postDelayed({
            val sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
            if (sharedPreferences.getBoolean("isLoggedIn",false)){
                // 스플래시 1초 후 바로 홈 화면으로
                commonUi.goToHome(view)
            }
            else{
                // 스플래시 1초 후 로그인 화면으로
                commonUi.goToLogin(view)
            }

            finish() // 스플래시는 꼭 종료시켜 주세요
        }, 1000)


    }


}