package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val displayMetrics = resources.displayMetrics
        val screenHeight = displayMetrics.heightPixels // Altura de la pantalla en píxeles
        val density = displayMetrics.density // Densidad de píxeles

        // Definir el padding como un porcentaje de la altura de la pantalla (por ejemplo, 5%)
        val paddingPercentage = 1.4f
        val paddingInDp = (screenHeight * paddingPercentage) / density // Convertimos el padding a dp
        val paddingInPixels = paddingInDp.toInt() // Convertimos el padding a píxeles

        binding.buttonContainer.setPadding(0, paddingInPixels, 0, 0) // Solo padding vertical


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
}