package com.himanshu.mvvmoverview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.himanshu.mvvmoverview.local.models.LoginResponseModel
import com.himanshu.mvvmoverview.repo.SharedRepository
import kotlinx.coroutines.launch

class MainViewModel(app: Application): AndroidViewModel(app) {

    private val sharedRepo = SharedRepository.getInstance(app.applicationContext)

    /**
     * With viewModelScope, you can avoid memory leakage with an ease of
     * executing suspend functions in it.
     *
     * With View Model, this method will also be destroyed.
     */
    fun getAllUsersFromDb(callback: (List<LoginResponseModel>) -> Unit) {
        viewModelScope.launch {
            val users = sharedRepo.getAllUsers()
            callback.invoke(users)
        }
    }

}