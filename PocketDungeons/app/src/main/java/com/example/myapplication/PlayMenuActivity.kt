package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityPlayMenuBinding
import timber.log.Timber

/**
 * Contains the logic for the first menu screen where the game's parameters are given by the user.
 */
class PlayMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayMenuBinding
    /**
     * Defines the basic logic to perform when creating the view.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_menu)

        binding.StartGame.setOnClickListener{
            val game = Intent(this, GameActivity::class.java)
            game.putExtra("slider_value", binding.sliderValue.text.toString().toInt())
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