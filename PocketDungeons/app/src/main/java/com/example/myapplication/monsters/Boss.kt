package com.example.myapplication.monsters

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
/**
 * Boss Class
 *
 * The Boss class branches from the monster abstract class, it contains the basic logic that
 * conforms a major foe
 */
class Boss(
    override val id: Int,
    override val foe: CharacterClass,
    override val monsterName: String,
    /*
    TODO Modify reward type to be object, we shall define objects first
     */
    private val reward: String,
    private val damage: List<Pair<Int, Int>>

): Monster(id,monsterName,foe) {
    private var found: Boolean = false
    fun changeState() {
        this.found = true
    }
    /**
     * Fight implementation for the Boss class
     */
    override fun fight(party: MutableLiveData<Map<CharacterClass, HeroCharacter>>): Int {
        if (this.found) {
           val partyLevel = calculatePartyLevel(party.value)
            for ((damageLevel,hits) in damage) {
                if (damageLevel >= partyLevel)
                    return hits
            }
        }
        return 0
    }
    /**
     * Calculates a party level where one the characters will be a special or powerful character
     */
    private fun calculatePartyLevel(tParty: Map<CharacterClass, HeroCharacter>?): Int {
        var partyLevel: Int = 0
        if (tParty != null) {
            for ((characterClass, hero) in tParty) {
                if (characterClass == this.foe) {
                    partyLevel += hero.getLevel() * 2
                } else {
                    partyLevel += hero.getLevel()
                }
            }
            return partyLevel
        }
        return 0
    }
}
