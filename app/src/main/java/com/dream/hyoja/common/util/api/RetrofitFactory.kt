package com.dream.hyoja.common.util.api

import com.dream.hyoja.common.model.User
import com.dream.hyoja.common.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/test/userList")
    fun getUsers(): Call<UserResponse>

    @POST("test/createUser")
    fun createUser(@Body user: User): Call<CreateUserResponse>

    @POST("test/login")
    fun login(@Body idPw: IdPw): Call<User>

}
data class IdPw(
    var id: String,
    var password: String
)

data class CreateUserResponse(
    var success: String,
    var status: Int,
    var msg: String
)
