package com.example.myapplication
/**
 * A basic Hero.
 *
 * This class defines the logic for the creation of a
 * simple Hero, one of the characters the user will
 * control.
 *
 * @constructor Creates a Hero with a type, and a color and is set to level 1.
 */
class HeroCharacter(
    private val characterClass: CharacterClass,
    private val color : Boolean
) {
    private var level: Int = 1
    /**
     * Sets the hero's information as text.
     * @return the text comprised of the hero's information.
     */
    override fun toString(): String {
        return "HeroCharacter(class=${this.characterClass}, level=${this.level}, color=${this.color})"
    }
    /**
     * Obtains a hero's level.
     * @return the level of the current hero instance.
     */
    fun getLevel():Int {
        return this.level
    }
    /**
     * Obtains a hero's Type.
     * @return the type of the current hero instance.
     */
    fun getCharacterClass():CharacterClass{
        return this.characterClass
    }
    /**
     * Obtains a hero's Color.
     * @return the color of the current hero instance.
     */
    fun getColor(): Boolean{
        //We´ll assume black to be False, and therefore white will be True
        return this.color
    }
    /**
     * Checks whether a hero can perform an action based on its color and type.
     * @return A boolean response True if capable false if not.
     */
    fun isAllowed(expectedClass: CharacterClass, expectedColor: Boolean) : Boolean
    {
        if (characterClass.name == expectedClass.name && expectedColor == this.color)
            return true
        else
            return false
    }
    /**
     * Ups a hero's level
     */
    fun up_level(){
        this.level += 1
    }
}