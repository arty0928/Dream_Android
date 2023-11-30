package com.dream.hyoja.common

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.dream.hyoja.R
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.common.util.api.RetrofitUtil

class SplashActivity : AppCompatActivity() {
    val commonUi = CommonUi()

    companion object{
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
        val id: String = sharedPreferences.getString("ID","fail").toString()
        val password: String = sharedPreferences.getString("PassWord","fail").toString()
        Log.d("id and pw", "$id---$password")

        var retrofitUtil = RetrofitUtil()
        retrofitUtil.login(id,password)

        val view = this
        Handler().postDelayed({

            if (retrofitUtil.loginResult){
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