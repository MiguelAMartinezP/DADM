package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityLoginBinding
import timber.log.Timber
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


private const val USER_NAME = "com.example.myapplication.Login:Name"
class LoginActivity : AppCompatActivity() {
    private lateinit var user : User
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var pass:String = ""
        var name:String = ""

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewModel = viewModel

        binding.inputLogin.setOnClickListener {
            pass = binding.password.text.toString()
            name = binding.name.text.toString()
            if (pass.isEmpty() or name.isEmpty())
            {
                Toast.makeText(this, "Password or name are empty", Toast.LENGTH_SHORT).show()
            }
            else {
                user = User(name, pass)
                viewModel.initUser(user)
                binding.user = viewModel.user

                Timber.i("User: %s with Password: %s", name, pass)
                val play = Intent(this, PlayMenu::class.java)
                //play.putExtra("USER_DATA", user)
                startActivity(play)
                Timber.i("Redirected after login in")
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("Instance saved")


        if (::user.isInitialized) {
            outState.putString(USER_NAME, user.name)
        }
    }
}