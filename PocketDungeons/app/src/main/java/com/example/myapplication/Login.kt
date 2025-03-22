package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.LoginBinding
import timber.log.Timber

private const val USER_NAME = "com.example.myapplication.Login:Name"
class Login : AppCompatActivity() {
    private lateinit var user : User
    private lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("Instance saved")


        outState.putString(USER_NAME, user.name)
    }
}