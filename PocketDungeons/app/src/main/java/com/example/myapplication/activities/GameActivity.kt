package com.example.myapplication.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGameBinding
import timber.log.Timber

/**
 *Game activity screen*.
 *
 * Defines a the infomation flow, as well as the screen throughout the Game.
 *
 */
class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val time = MutableLiveData<Int>()
    private var characters: MutableLiveData<Map<CharacterClass, HeroCharacter>> = MutableLiveData(
        mapOf(
            CharacterClass.BRUTE to HeroCharacter(CharacterClass.BRUTE, false),
            CharacterClass.MAGE to HeroCharacter(CharacterClass.MAGE, true),
            CharacterClass.CLERIC to HeroCharacter(CharacterClass.CLERIC, false),
            CharacterClass.ROGUE to HeroCharacter(CharacterClass.ROGUE, true)
        )
    )
    /**
     * Part of this screen´s lifecycle, it defines the actions to be performed
     * on creation of said activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        val character_map = characters.value?.toMutableMap() ?: mutableMapOf()
        var brute = character_map[CharacterClass.BRUTE]
        binding.brute = brute

        binding.testLevelButton.setOnClickListener{
            val updatedMap = characters.value?.toMutableMap() ?: mutableMapOf()
            var brute = updatedMap[CharacterClass.BRUTE]
            binding.brute = brute
            brute?.up_level()
            Timber.i("Nivel subido")
            characters.value = updatedMap
            Timber.i("Personajes: ${characters.value}")

        }

        time.value = intent.getIntExtra("slider_value", 45)

        binding.time = time

    }
}