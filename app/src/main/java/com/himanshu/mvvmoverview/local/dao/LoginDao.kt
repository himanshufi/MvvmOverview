package com.himanshu.mvvmoverview.local.dao

import androidx.room.*
import com.himanshu.mvvmoverview.local.models.LoginResponseModel

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: LoginResponseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(item: List<LoginResponseModel>)

    @Query("SELECT * FROM LoginResponseModel")
    suspend fun getAllItems(): List<LoginResponseModel>

    @Delete
    suspend fun deleteItem(item: LoginResponseModel)

}