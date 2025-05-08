package com.example.myapplication.monsters

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
/**
 * Monster Abstract Class
 *
 * The monster class is an abstract layer which contains the basic information for a foe
 */
abstract class Monster(
    open val id:Int,
    open val monsterName: String,
    open val foe: CharacterClass
)

{
    /**
     * Fight function will deduct hp points from the class based on the foe´s capabilities
     */
   abstract fun fight(party: MutableLiveData<Map<CharacterClass, HeroCharacter>>):Int
}
