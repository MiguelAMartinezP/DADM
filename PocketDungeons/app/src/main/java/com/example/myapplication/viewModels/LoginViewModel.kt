package com.example.myapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.User
import timber.log.Timber

/**
 * View model for the user.
 * Separates the user's logic from the ui in order to maintain it in memory.
 *
 * @init Logs the creation of the viewModel in our timber tree.
 */
class LoginViewModel : ViewModel() {
    var user = MutableLiveData<User>()


    init {
        Timber.i("LoginViewModel created")
    }

    /**
     * Initialises a user as we need an already created instance of it due to the user's logic.
     */
    fun initUser(user: User){
        this.user.value = user
        Timber.i("Init LoginViewModel")
    }


    /**
     * Logs the destruction of the viewModel.
     */
    override fun onCleared() {
        super.onCleared()
        Timber.i("LoginViewModel destroyed")
    }
}