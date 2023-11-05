package com.example.hyoja.common.util.api

import com.example.hyoja.common.model.User
import com.example.hyoja.common.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/test/userList")
    fun getUsers(): Call<UserResponse>

    @POST("test/createUser")
    fun createUser(@Body user: User): Call<User>
}
