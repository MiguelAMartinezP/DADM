package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import timber.log.Timber

/**
 * Contains the logic for the starting screen of the game.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var user : User
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    /**
     * Defines the basic logic to perform when creating the view.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.playButton.setOnClickListener{
            val play = Intent(this, PlayMenuActivity::class.java)
            startActivity(play)
            Timber.i("Play button clicked")
        }
        binding.loginButton.setOnClickListener {
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
            Timber.i("Login Button clicked")
        }


        Toast.makeText(this,"Bienvenido jugador", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        //user = viewModel.user


        Timber.i("HOLA")

        if (::user.isInitialized) {
            Timber.i("SIU")
            user = viewModel.user
            Timber.i(user.name)
        }


        Timber.i("ÑO")


    }
}