package com.example.myapplication.monsters

import com.example.myapplication.CharacterClass

abstract class Monster(
    open val id:Int,
    open val monsterName: String,
    open val foe: CharacterClass
)