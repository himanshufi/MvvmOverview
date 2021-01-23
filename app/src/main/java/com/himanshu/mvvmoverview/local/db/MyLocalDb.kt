package com.himanshu.mvvmoverview.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.himanshu.mvvmoverview.local.dao.LoginDao
import com.himanshu.mvvmoverview.local.models.LoginResponseModel

@Database(entities = [
    LoginResponseModel::class], version = 1)
abstract class MyLocalDb: RoomDatabase() {

    abstract fun getLoginDao(): LoginDao

}