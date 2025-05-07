package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.viewModels.LoginViewModel
import com.example.myapplication.R
import com.example.myapplication.USER_NAME
import com.example.myapplication.data.dao.UserDao
import com.example.myapplication.data.database.DatabaseProvider
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch
import timber.log.Timber
import com.google.firebase.auth.FirebaseAuth

/**
 * Defines the logic for the Login screen.
 */
class LoginActivity : AppCompatActivity() {
    //Debido a problemas de compatibilidad desaparece la primer instancia de user que creamos,
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    private lateinit var auth: FirebaseAuth

    /**
     * Comprised of the logic executed when Creating the screen for the first time.
     */
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var pass:String = ""
        var name:String = ""
        var user:User?



        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val db = DatabaseProvider.getDatabase(this)

        auth = FirebaseAuth.getInstance()

        binding.viewModel = viewModel

        binding.inputLogin.setOnClickListener {
            val pass = binding.password.text.toString()
            val name = binding.name.text.toString()

            if (pass.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Password or name are empty", Toast.LENGTH_SHORT).show()
            } else {
                lifecycleScope.launch {
                    val user = db.userDao().login(name, pass)

                    if (user != null) {
                        Timber.i("Usuario logeado en Room: ${user.name}")
                        viewModel.initUser(user)
                        auth.signInWithEmailAndPassword(name, pass)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Timber.i("Login exitoso en Firebase")
                                } else {
                                    Timber.i("Error: ${task.exception?.message}")
                                }
                            }

                    } else {
                        Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                        Timber.i("Fallo en login")
                    }
                }
                //val intent = Intent(this@LoginActivity, MainActivity::class.java)
                //startActivity(intent)
                finish()
            }

            }

        binding.linkText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.backButton.setOnClickListener{
            //if (::user.isInitialized)
            //{
                //val intent = Intent().apply {
                //    putExtra("User", user)
                //}
                //setResult(RESULT_OK, intent)
            //}
            lifecycleScope.launch {
                val u = db.userDao().getUserByName("test")
                Timber.i("Usuario obtenido ole: ${u?.password}")
            }
            finish()
        }
    }

    /**
     * Maintains the user's information if the view is destroyed.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("Instance saved")


        //if (::user.isInitialized) {
          //  outState.putString(USER_NAME, user.name)
        //}
    }
}