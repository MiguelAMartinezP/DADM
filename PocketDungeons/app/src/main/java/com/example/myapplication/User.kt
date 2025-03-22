package com.example.myapplication
import kotlin.random.Random

data class User(val name: String, val password: String) {
    private var hashcode = Random.nextInt(0, 9)
}