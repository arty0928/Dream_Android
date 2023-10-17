package com.example.hyoja.common.util

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.hyoja.cafe.CafeHome1Activity
import com.example.hyoja.cafe.CafeHome2Activity
import com.example.hyoja.cafe.CafeHomeActivity
import com.example.hyoja.cinema.CinemaHomeActivity
import com.example.hyoja.common.AccountCreateActivity
import com.example.hyoja.common.LoginActivity
import com.example.hyoja.common.MainActivity
import com.example.hyoja.cafe.CafeNewTabActivity
import com.example.hyoja.fastfoods.FastFoodHome1Activity
import com.example.hyoja.fastfoods.FastFoodHome2Activity
import com.example.hyoja.fastfoods.FastFoodHomeActivity

//import com.example.hyoja.fastfoods.TabActivity


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
        Log.d("goToCinema","영화관 홈으로 전환")
    }

    fun goToFastFoodHome1(v: Context){
        val intent = Intent(v, FastFoodHome1Activity::class.java)
        v.startActivity(intent)
        Log.d("goToCinema","영화관 홈으로 전환")
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

    fun goToCafeHome1coffee(v: Context) {
        val intent = Intent(v, CafeHome2Activity::class.java)
        v.startActivity(intent)
        Log.d("goToCafe", "카페홈2로 전환")
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

<<<<<<< HEAD
    fun goToCafeTabTest(v: Context) {
        val intent = Intent(v, CafeNewTabActivity::class.java)
        v.startActivity(intent)
        Log.d("goToCafeTabTest", "tab test 화면으로 전환")}

    fun goToFastfoodTabTest(v: Context) {

        val intent = Intent(v, NewTabActivity::class.java)
        v.startActivity(intent)
        Log.d("goToFastfoodTabTest", "tab test 화면으로 전환")
    }

}

=======
>>>>>>> fastfood
//    이전 화면으로 이동

