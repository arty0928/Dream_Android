package com.dream.hyoja.common.model


data class UserResponse(
    val success: Boolean,
    val data: List<User>,
    val status: Int
)

data class User(
    val id: String,
    val password: String,
    val name: String
)
