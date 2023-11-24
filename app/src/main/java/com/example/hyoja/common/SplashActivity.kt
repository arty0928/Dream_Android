package com.example.hyoja.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.common.util.api.RetrofitUtil

class SplashActivity : AppCompatActivity() {
    val commonUi = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
        val id: String = sharedPreferences.getString("ID","fail").toString()
        val password: String = sharedPreferences.getString("Password","fail").toString()
        Log.d("id and pw", id +"\n"+ password)

        val view = this
        Handler().postDelayed({
            if (RetrofitUtil().login(id,password)){
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