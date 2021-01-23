package com.himanshu.mvvmoverview.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginResponseModel(
    val first_name:String,
    val last_name:String? = "",
    @PrimaryKey val email:String,
    val phone:String? = "",
    val gender:String? = "",
    val access_token:String,
    val refresh_token:String
)