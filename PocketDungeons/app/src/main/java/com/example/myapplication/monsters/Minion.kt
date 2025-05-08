package com.example.myapplication.monsters

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
/**
 * Minion Class
 *
 * The minion class branches from the monster abstract class, it contains the basic logic that
 * conforms a minor foe
 */
class Minion (
    override val id: Int,
    override val foe: CharacterClass,
    override val monsterName: String,
    private val monsterLevel: Int
    ): Monster(id,monsterName,foe)
{
    /**
     * Fight implementation for the minion class
     */
    override fun fight(party: MutableLiveData<Map<CharacterClass, HeroCharacter>>):Int {
        val characterLevel = party.value!!.getValue(this.foe).getLevel()
        val damage = maxOf(monsterLevel-characterLevel,0)
        return damage
    }

    }
