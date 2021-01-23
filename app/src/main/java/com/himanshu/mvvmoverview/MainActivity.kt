package com.himanshu.mvvmoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.himanshu.mvvmoverview.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    /**
     * This is the most easiest way to initialize a View Model.
     * See this for more info: https://twitter.com/himanshufi/status/1349013205285285893
     *
     */
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllUsers()
    }

    private fun getAllUsers() {
        viewModel.getAllUsersFromDb {
            /**
             * You will get all the users here. The flow will be:
             * Local DB (SQLite) -> SharedRepository -> MainViewModel -> MainActivity
             */
        }
    }
}