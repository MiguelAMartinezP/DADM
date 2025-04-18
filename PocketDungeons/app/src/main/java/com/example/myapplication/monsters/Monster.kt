package com.example.myapplication.monsters

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter

abstract class Monster(
    open val id:Int,
    open val monsterName: String,
    open val foe: CharacterClass
)
{
   abstract fun fight(party: MutableLiveData<Map<CharacterClass, HeroCharacter>>):Int
   fun getId():Int
   {
       return this.id
   }
    fun getMonsterName():String{
        return monsterName
    }
    fun getFoe():CharacterClass{
        return this.foe
    }
}
