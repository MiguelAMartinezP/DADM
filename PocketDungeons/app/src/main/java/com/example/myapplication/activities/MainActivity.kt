package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.viewModels.LoginViewModel
import com.example.myapplication.R
import com.example.myapplication.User
import com.example.myapplication.data.database.DatabaseProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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
    private lateinit var auth: FirebaseAuth
    private lateinit var authListener: FirebaseAuth.AuthStateListener
    /**
     * Defines the basic logic to perform when creating the view.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        // Configura el listener de autenticación
        authListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            /*updateUI(user)*/
        }

        binding.menuButton.setOnClickListener {
            showPopupMenu()
        }

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
    /**
     * Reloads the information found in the authentication layer on activity start
     */
    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(authListener) // Registra el listener
    }

    /**
     * Removes the authentication layer on activity stop
     */
    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener(authListener) // Elimina el listener
    }

    /**
     * Contains the logic which comprises the popup Menu
     * shows the current user and offers the option to log off.
     */
    private fun showPopupMenu() {
        val anchorView = binding.menuButton
        val popupMenu = PopupMenu(this, anchorView)
        popupMenu.menuInflater.inflate(R.menu.user_popup, popupMenu.menu)

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val email = currentUser.email ?: "Email no disponible"
            popupMenu.menu.findItem(R.id.menu_email).title = "Usuario: $email"
            popupMenu.menu.findItem(R.id.menu_logout).isVisible = true
        } else {
            popupMenu.menu.findItem(R.id.menu_email).title = "No logueado"
            popupMenu.menu.findItem(R.id.menu_logout).isVisible = false
        }

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_logout -> {
                    auth.signOut()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

}