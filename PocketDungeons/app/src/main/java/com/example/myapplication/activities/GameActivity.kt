package com.example.myapplication.activities
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGameBinding
import com.example.myapplication.viewModels.GameViewModel
import timber.log.Timber

/**
 *Game activity screen*.
 *
 * Defines a the infomation flow, as well as the screen throughout the Game.
 *
 */
class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val viewModel: GameViewModel by lazy {
        ViewModelProvider(this)[GameViewModel::class.java]
    }

    /**
     * Part of this screen´s lifecycle, it defines the actions to be performed
     * on creation of said activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        val character_map = viewModel.getCharacters()?.value?.toMutableMap() ?: mutableMapOf()
        var brute = character_map[CharacterClass.BRUTE]
        binding.brute = brute

        viewModel.getTime().value = intent.getIntExtra("slider_value", 45)

        binding.time = viewModel.getTime()

    }

    override fun onResume() {
        super.onResume()

        val character_map = viewModel.getCharacters()?.value?.toMutableMap() ?: mutableMapOf()
        var brute = character_map[CharacterClass.BRUTE]

        binding.testLevelButton.setOnClickListener{
            binding.brute = brute
            brute?.up_level()
            Timber.i("Nivel subido")
            viewModel.getCharacters()?.value = character_map
            Timber.i("Personajes: ${viewModel.getCharacters()?.value}")

        }
    }
}