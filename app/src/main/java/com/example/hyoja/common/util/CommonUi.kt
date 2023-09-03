package com.example.hyoja.common.util

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.hyoja.cinema.CinemaHomeActivity
import com.example.hyoja.common.MainActivity

// 앱 전반적으로 사용하는 함수 모음 클래스
class CommonUi {
    // 홈으로 가는 함수
    fun goToHome(v: Context){
        val intent = Intent(v, MainActivity::class.java)
        v.startActivity(intent)
        Log.d("goToHome","홈 화면으로 전환")
    }
    fun goToCinema(v: Context){
        val intent = Intent(v, CinemaHomeActivity::class.java)
        v.startActivity(intent)
        Log.d("goToCinema","영화관 홈으로 전환")
    }

}