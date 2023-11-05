package com.example.hyoja.common.util.api

import android.util.Log
import com.example.hyoja.common.model.User
import com.example.hyoja.common.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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

    fun createUser(id: String, password:String, name: String){
        val user = User(id, password, name)

        val call = service.createUser(user)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Log.d("response", "User created successfully")
                } else {
                    Log.d("response", "Failed to create user")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("response", "Failed to create user")
                Log.d("reason", t.message.toString())
            }
        })
    }


}