package com.example.hyoja.common.util.api

import android.content.Context
import androidx.room.Room
import com.example.hyoja.common.model.User
import com.example.hyoja.common.util.CommonUi
import java.util.*

class UnrealAPI (applicationContext: Context){
    val commonUi:CommonUi = CommonUi()

    val database = Room.databaseBuilder(
        applicationContext,
        UserDatabase::class.java,
        "hyoja_db"
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    // 인터페이스 객체 할당
    val userDao = database.userDao()

    fun createUser(user: User):String{
        var user:User = user
        if(user.name.length>6|| user.name.isEmpty()){
            return "name error"
        } else if(user.password.isEmpty()){
            return "password error"
        }
        user.id = commonUi.makeRandomString(7)
        userDao.setInsert(user)

        val result: String = """
        {
            "success": true,
            "status": 200,
            "id": "${user.id}"
        }"""

        return result
    }
}