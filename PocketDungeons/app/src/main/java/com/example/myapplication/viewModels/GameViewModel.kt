package com.example.myapplication.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.CharacterClass
import com.example.myapplication.Die
import com.example.myapplication.HeroCharacter
import timber.log.Timber

class GameViewModel : ViewModel() {
    private var potionNumber: Int = 0
    //TODO define objects and how these are to be shared.
    private var hits: MutableLiveData<Int> = MutableLiveData(0)
    private var dice: List<Die> = listOf(Die(),Die(),Die())
    private var round: MutableLiveData<Int> = MutableLiveData(1)
    private var characters: MutableLiveData<Map<CharacterClass, HeroCharacter>> = MutableLiveData(
        mapOf(
            CharacterClass.BRUTE to HeroCharacter(CharacterClass.BRUTE, false),
            CharacterClass.MAGE to HeroCharacter(CharacterClass.MAGE, true),
            CharacterClass.CLERIC to HeroCharacter(CharacterClass.CLERIC, false),
            CharacterClass.ROGUE to HeroCharacter(CharacterClass.ROGUE, true)
        )
    )
    private val time = MutableLiveData<Int>()
    private var savedTimeWindow: Int = 0
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
    fun setSavedTimeWindow(seconds: Int){
        this.savedTimeWindow = seconds
    }
    fun setTime(seconds:Int){
        this.time.value = seconds
    }
    fun getRound(): MutableLiveData<Int>{
        return this.round
    }
    fun addRounds(nRounds:Int){
        this.round.value = this.round.value?.plus(nRounds)
    }
    fun addRound(){
        this.round.value = this.round.value?.plus(1)
        this.setTime(this.savedTimeWindow)
    }
    fun getHits():MutableLiveData<Int>
    {
        return this.hits
    }
    fun getCharacters():MutableLiveData<Map<CharacterClass, HeroCharacter>>?{
        return this.characters
    }
    fun getTime():MutableLiveData<Int>{
        return this.time
    }
    fun getDice():List<Die>{
        return this.dice
    }
    fun addHits(nHits:Int){
        this.hits.value = this.hits.value?.plus(nHits)
    }
    fun addHit(){
        this.hits.value = this.hits.value?.plus(1)
    }
    fun addPotion(){
        potionNumber += 1
    }
    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }
}
