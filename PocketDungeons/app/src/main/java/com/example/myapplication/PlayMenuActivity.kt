package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityPlayMenuBinding
import timber.log.Timber

class PlayMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_menu)

        binding.StartGame.setOnClickListener{
            val game = Intent(this, GameActivity::class.java)
            startActivity(game)
            Timber.i("Game starting")
        }
        binding.backButton.setOnClickListener{
            finish()
        }
        binding.slider.addOnChangeListener{ _, value, _ ->
            binding.sliderValue.text = "${value.toInt()}"
        }

    }
}