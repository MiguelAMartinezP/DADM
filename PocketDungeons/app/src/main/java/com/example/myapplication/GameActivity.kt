package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityGameBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var characters: LiveData<Map<CharacterClass,HeroCharacter>> = MutableLiveData(
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


    }
}