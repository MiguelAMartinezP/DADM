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
import com.example.myapplication.USER_NAME
import com.example.myapplication.data.dao.UserDao
import com.example.myapplication.data.database.DatabaseProvider
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Defines the logic for the Login screen.
 */
class RegisterActivity : AppCompatActivity() {
    //Debido a problemas de compatibilidad desaparece la primer instancia de user que creamos,
    private lateinit var userInsert : User
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    /**
     * Comprised of the logic executed when Creating the screen for the first time.
     */
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var pass:String = ""
        var name:String = ""

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        val db = DatabaseProvider.getDatabase(this)

        binding.inputRegister.setOnClickListener {
            pass = binding.password.text.toString()
            name = binding.name.text.toString()
            if (pass.isEmpty() || name.isEmpty())
            {
                Toast.makeText(this, "Password or name are empty", Toast.LENGTH_SHORT).show()
            }
            else {
                lifecycleScope.launch {
                    userInsert = User(0, name, pass)
                    val user = db.userDao().register(userInsert)
                    Timber.i("Usuario registrado en Room con id: $user")
                    finish()
                }
            }

        }

        binding.backButton.setOnClickListener{
            //if (::user.isInitialized)
            //{
            //val intent = Intent().apply {
            //    putExtra("User", user)
            //}
            //setResult(RESULT_OK, intent)
            //}
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