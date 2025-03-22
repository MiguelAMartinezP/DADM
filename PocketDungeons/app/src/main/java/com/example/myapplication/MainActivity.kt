package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var playButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.PlayButton)

        playButton.setOnClickListener{
            val intent = Intent(this, PlayMenu::class.java)
            startActivity(intent)
            Timber.i("Play button clicked")
        }
        Toast.makeText(this,"Bienvenido jugador", Toast.LENGTH_SHORT).show()
    }
}