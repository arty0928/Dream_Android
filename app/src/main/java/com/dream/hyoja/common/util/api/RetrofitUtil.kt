package com.dream.hyoja.common.util.api

import android.util.Log
import com.dream.hyoja.common.model.User
import com.dream.hyoja.common.model.UserResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    //retrofit 빌드
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://hyoja.site/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //create
    private val service = retrofit.create(ApiService::class.java)

    fun userList(){
        //getUser로 설정
        val call = service.getUsers()

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data // 사용자 목록을 가져옵니다.
                    Log.d("response", users.toString())
                } else {
                    Log.d("response", "fail")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("response", "fail")
                Log.d("reason", t.message.toString())
            }
        })
    }

    var ID =""
    fun createUser(id: String, password:String, name: String) = CoroutineScope(Dispatchers.Main).launch {
        val user = User(id,password,name)
        try {
            val response = service.createUser(user).await()
            ID = response.msg
            Log.d("messageID", ID)

        } catch (exception: Exception){
            Log.d("createUser", "fail\n$exception")
        }
    }

    var loginResult: Boolean = false
    fun login(id: String, password: String) = CoroutineScope(Dispatchers.Main).launch {
        val idPw = IdPw(id, password)
        try {
            val response = service.login(idPw).await()
            Log.d("serverID",response.msg)
            val jsonString = response.msg
            val userString = jsonString.substring(jsonString.indexOf("(") + 1, jsonString.indexOf(")"))
            val userFields = userString.split(", ")
            val id = userFields[0].substring(userFields[0].indexOf("=") + 1)
            val password = userFields[1].substring(userFields[1].indexOf("=") + 1)
            val name = userFields[2].substring(userFields[2].indexOf("=") + 1)
            val user = User(id, password, name)

            if (user.id == id) {
                Log.d("onResponse", response.msg.toString())
                loginResult = true
            } else {
                Log.d("response", "Failed to login")
                Log.d("onResponse", response.msg.toString())
                loginResult = false
            }
        } catch (e: Exception) {
            Log.d("catch", "error")
            Log.d("reason", e.message.toString())
            loginResult = false
        }

    }


}