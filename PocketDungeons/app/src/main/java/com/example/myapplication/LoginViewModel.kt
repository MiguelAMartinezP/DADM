package com.example.myapplication

import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * View model for the user.
 * Separates the user's logic from the ui in order to maintain it in memory.
 *
 * @init Logs the creation of the viewModel in our timber tree.
 */
class LoginViewModel : ViewModel() {
    lateinit var user: User

    init {
        Timber.i("MainViewModel created")
    }

    /**
     * Initialises a user as we need an already created instance of it due to the user's logic.
     */
    fun initUser(user: User){
        this.user = user
    }
    /**
     * Logs the destruction of the viewModel.
     */
    override fun onCleared() {
        super.onCleared()
        Timber.i("MainViewModel destroyed")
    }
}