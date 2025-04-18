package com.example.myapplication.monsters

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter

class Minion (
    override val id: Int,
    override val foe: CharacterClass,
    override val monsterName: String,
    private val monsterLevel: Int
    ): Monster(id,monsterName,foe)
{
    override fun fight(party: MutableLiveData<Map<CharacterClass, HeroCharacter>>):Int {
        val characterLevel = party.value!!.getValue(this.getFoe()).getLevel()
        val damage = maxOf(monsterLevel-characterLevel,0)
        return damage
    }

    }
