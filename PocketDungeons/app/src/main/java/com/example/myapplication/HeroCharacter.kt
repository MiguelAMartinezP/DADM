package com.example.myapplication
import kotlin.random.Random
class HeroCharacter(
    private val characterClass: CharacterClass,
    private var level: Int,
    private val color : Boolean
) {
    fun getLevel():Int {
        return this.level
    }
    fun getCharacterClass():CharacterClass{
        return this.characterClass
    }
    fun getColor(): Boolean{
        //We´ll assume black to be False, and therefore white True
        return this.color
    }
    fun isAllowed(expectedClass: CharacterClass, expectedColor: Boolean):Boolean{

        if (characterClass.name == expectedClass.name && expectedColor == this.color)
            return true
        else
            return false


        }
    fun up_level(){
        this.level += 1
    }
}