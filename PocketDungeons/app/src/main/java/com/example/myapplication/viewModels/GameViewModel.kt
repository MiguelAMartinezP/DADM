package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.myapplication.Die
import timber.log.Timber

class GameViewModel : ViewModel() {
    private var potionNumber: Int = 0
    //TODO define objects and how these are to be shared.
    private var hits: Int = 0
    private var dice: List<Die> = listOf(Die(),Die(),Die())

    init {
        Timber.i("GameViewModel created")
    }
    fun rollDice():List<Pair<String,Boolean>>{
        val retList = mutableListOf<Pair<String,Boolean>>()
        for (die in dice){
            retList.addLast(die.roll())
        }
        return retList

    }
    fun addHits(nHits:Int){
        this.hits += nHits
    }
    fun addHit(){
        this.hits += 1
    }
    fun addPotion(){
        potionNumber += 1
    }
    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }
}
