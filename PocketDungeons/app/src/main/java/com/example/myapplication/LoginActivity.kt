package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityLoginBinding
import timber.log.Timber
import android.widget.Toast


private const val USER_NAME = "com.example.myapplication.Login:Name"
class LoginActivity : AppCompatActivity() {
    private lateinit var user : User
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var pass:String = ""
        var name:String = ""

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.inputLogin.setOnClickListener {
            pass = binding.password.text.toString()
            name = binding.name.text.toString()
            if (pass.isEmpty() or name.isEmpty())
            {
                Toast.makeText(this, "Password or name are empty", Toast.LENGTH_SHORT).show()
            }
            else {
                user = User(name, pass)
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


        outState.putString(USER_NAME, user.name)
    }
}