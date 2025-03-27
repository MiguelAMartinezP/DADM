package com.example.myapplication

import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel : ViewModel() {
    lateinit var user: User

    init {
        Timber.i("MainViewModel created")
    }

    fun initUser(user: User){
        this.user = user
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("MainViewModel destroyed")
    }
}