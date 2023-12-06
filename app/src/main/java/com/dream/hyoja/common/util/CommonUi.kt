package com.dream.hyoja.common.util

import android.content.Context
import android.content.Intent
import android.util.Log
import com.dream.hyoja.activity.CafeStartExplain
import com.dream.hyoja.cafe.CafeHome1Activity
import com.dream.hyoja.cafe.CafeHomeActivity
import com.dream.hyoja.cinema.CinemaHomeActivity
import com.dream.hyoja.common.AccountCreateActivity
import com.dream.hyoja.common.LoginActivity
import com.dream.hyoja.common.MainActivity
import com.dream.hyoja.fastfoods.FastFoodHome1Activity
import com.dream.hyoja.fastfoods.FastFoodHome2Activity
import com.dream.hyoja.fastfoods.FastFoodHomeActivity
import com.dream.hyoja.fastfoods.FastFoodPayActivity
import com.dream.hyoja.fastfoods.model.FastFoodModel


// 앱 전반적으로 사용하는 함수 모음 클래스
class CommonUi {
    // 홈으로 가는 함수
    fun goToHome(v: Context) {
        val intent = Intent(v, MainActivity::class.java)
        v.startActivity(intent)
        Log.d("goToHome", "홈 화면으로 전환")
    }

    fun goToCinema(v: Context) {
        val intent = Intent(v, CinemaHomeActivity::class.java)
        v.startActivity(intent)
        Log.d("goToCinema", "영화관 홈으로 전환")
    }

    fun goToFastFood(v: Context){
        val intent = Intent(v, FastFoodHomeActivity::class.java)
        v.startActivity(intent)
        Log.d("goToFastFood","패스트푸드 홈으로 전환")
    }

    fun goToFastFoodHome1(v: Context){
        FastFoodModel.foodSelectedList.clear()
        val intent = Intent(v, FastFoodHome1Activity::class.java)
        v.startActivity(intent)
        Log.d("goToFastFood","패스트푸드 홈으로 전환")
    }

    fun goToFastFoodPayHome(v: Context){
        val intent = Intent(v, FastFoodPayActivity::class.java)
        v.startActivity(intent)
        Log.d("goToFastFood","패스트푸드 홈으로 전환")
    }

    fun goToFastFoodHome1Button1(v: Context){
        val intent = Intent(v, FastFoodHome2Activity::class.java)
        v.startActivity(intent)
        Log.d("goToCinema","영화관 홈으로 전환")
    }

    fun goToCafe(v: Context) {
        val intent = Intent(v, CafeHomeActivity::class.java)
        v.startActivity(intent)
        Log.d("goToCafe", "카페 홈으로 전환")
    }

    fun goToCafeHome1(v: Context) {
        val intent = Intent(v, CafeHome1Activity::class.java)
        v.startActivity(intent)
        Log.d("goToCafe", "카페홈1로 전환")
    }


    fun goToLogin(v: Context) {
        val intent = Intent(v, LoginActivity::class.java)
        v.startActivity(intent)
        Log.d("goToLogin", "로그인 화면으로 전환")
    }

    fun goToAccountCreate(v: Context) {
        val intent = Intent(v, AccountCreateActivity::class.java)
        v.startActivity(intent)
        Log.d("goToAccountCreate", "회원가입 화면으로 전환")
    }
    fun makeRandomString(length: Int):String{
        val charset = ('0'..'9')+('a'..'z')+('A'..'Z')
        var string:String = List(length){charset.random()}.joinToString("")
        return string
    }

    fun goToCafeStartEx(v: Context) {
        val intent = Intent(v, CafeStartExplain::class.java)
        v.startActivity(intent)
        Log.d("goToAccountCreate", "회원가입 화면으로 전환")
    }

}
//    이전 화면으로 이동

