package com.example.myapplication
import timber.log.Timber
import kotlin.random.Random
class HeroCharacter(
    private val characterClass: CharacterClass,
    private var level: Int,
    private val color : Boolean
) {
    override fun toString(): String {
        return "HeroCharacter(class=${this.characterClass}, level=${this.level}, color=${this.color})"
    }
    fun getLevel():Int {
        return this.level
    }
    fun getCharacterClass():CharacterClass{
        return this.characterClass
    }
    fun getColor(): Boolean{
        //We´ll assume black to be False, and therefore white will be True
        return this.color
    }
    fun isAllowed(expectedClass: CharacterClass, expectedColor: Boolean) : Boolean
    {
        if (characterClass.name == expectedClass.name && expectedColor == this.color)
            return true
        else
            return false
    }
    fun up_level(){
        this.level += 1
    }
}