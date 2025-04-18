package com.example.myapplication

/**
 *Dice Class
 *
 * Defines the basic data required for any dice, and the methods required for its
 * basic function
 */
class Die {
    private val faces: List<String> = listOf("SKULL", "BOOTS", "MAGE", "CLERIC", "ROGUE", "BRUTE")
    private val color: List<Boolean> = listOf(true, false)
    /**
     * Simulates a Dice roll, returning both the color and face of said dice
     */
    fun roll():Pair<String,Boolean>{
        return Pair(faces.random(),color.random())
    }
}