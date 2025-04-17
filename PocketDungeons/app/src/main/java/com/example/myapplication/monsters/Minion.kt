package com.example.myapplication.monsters

import com.example.myapplication.CharacterClass

class Minion (
    override val id: Int,
    override val foe: CharacterClass,
    override val monsterName: String,
    private val monsterLevel: Int
    ): Monster(id,monsterName,foe)
