package com.example.hyoja.common.util.api

import androidx.room.*
import com.example.hyoja.common.model.User

@Dao
interface UserDao{
    @Insert
    fun setInsert(user: User)

    @Delete
    fun setDelete(user: User)
}
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}