package com.himanshu.mvvmoverview.local

import android.content.Context
import androidx.room.Room
import com.himanshu.mvvmoverview.local.dao.LoginDao
import com.himanshu.mvvmoverview.local.db.MyLocalDb

class DbRepository(private val database: MyLocalDb) {

    companion object {
        private var instance: DbRepository? = null

        fun getInstance(context: Context): DbRepository {
            return instance ?: synchronized(this) {
                instance ?: DbRepository(initializeDb(context)).also { instance = it }
            }
        }

        /**
         * This will create a new db with the name of `myLocalDb`.
         */
        private fun initializeDb(context: Context): MyLocalDb {
            return Room.databaseBuilder(
                context,
                MyLocalDb::class.java, "myLocalDb"
            ).build()
        }
    }

    fun loginDao():LoginDao = database.getLoginDao()

}