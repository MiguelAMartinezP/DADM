package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityGameBinding
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var characters: MutableLiveData<Map<CharacterClass,HeroCharacter>> = MutableLiveData(
        mapOf(
        CharacterClass.BRUTE to HeroCharacter(CharacterClass.BRUTE,1,false),
            CharacterClass.MAGE to HeroCharacter(CharacterClass.MAGE,1,true),
            CharacterClass.CLERIC to HeroCharacter(CharacterClass.CLERIC,1,false),
            CharacterClass.ROGUE to HeroCharacter(CharacterClass.ROGUE,1,true)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        binding.testLevelButton.setOnClickListener{
            val updatedMap = characters.value?.toMutableMap() ?: mutableMapOf()
            var brute = updatedMap[CharacterClass.BRUTE]
            binding.brute = brute
            brute?.up_level()
            Timber.i("Nivel subido")
            characters.value = updatedMap
            Timber.i("Personajes: ${characters.value}")

        }

    }
}