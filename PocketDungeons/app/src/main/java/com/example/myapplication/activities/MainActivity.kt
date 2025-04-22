package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.viewModels.LoginViewModel
import com.example.myapplication.R
import com.example.myapplication.User
import com.example.myapplication.data.database.DatabaseProvider
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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


        Toast.makeText(this, getString(R.string.welcome_msg), Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        val db = DatabaseProvider.getDatabase(applicationContext)
        lifecycleScope.launch(Dispatchers.IO) {
            val savedUser = db.userDao().getUserByName("nombreUsuario") // o el último usuario si guardas eso
            if (savedUser != null) {
                withContext(Dispatchers.Main) {
                    viewModel.initUser(savedUser)
                    Timber.i("Usuario cargado desde Room: ${savedUser.name}")
                }
            }
        }



    }
}