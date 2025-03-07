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


class MainActivity : AppCompatActivity() {
    private lateinit var playButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.PlayButton)

        playButton.setOnClickListener{
            val intent = Intent(this, PlayMenu::class.java)
            startActivity(intent)
        }
    }
}