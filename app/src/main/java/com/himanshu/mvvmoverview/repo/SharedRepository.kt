package com.himanshu.mvvmoverview.repo

import android.content.Context
import com.himanshu.mvvmoverview.local.DbRepository
import com.himanshu.mvvmoverview.local.models.LoginResponseModel

class SharedRepository(private val dbRepo: DbRepository) {

    companion object {
        private var instance: SharedRepository? = null

        /**
         * This will create a single instance of the SharedRepository.
         */
        fun getInstance(context: Context): SharedRepository {
            return instance ?: synchronized(this) {
                instance ?: SharedRepository(
                    DbRepository.getInstance(context)
                ).also { instance = it }
            }
        }
    }

    /**
     * Remember suspend functions can only be called by a suspend function.
     */
    suspend fun getAllUsers(): List<LoginResponseModel> {
        return dbRepo.loginDao().getAllItems()
    }

}