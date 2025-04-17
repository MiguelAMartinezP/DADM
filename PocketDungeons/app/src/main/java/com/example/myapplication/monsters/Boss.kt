package com.example.myapplication.monsters

import com.example.myapplication.CharacterClass

class Boss(
    override val id: Int,
    override val foe: CharacterClass,
    override val monsterName: String,
    /*
    TODO Modify reward type to be object, we shall define objects first
     */
    private val reward: String,
    private val damage: Map<String, Int>

): Monster(id,monsterName,foe)
