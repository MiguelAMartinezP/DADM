package com.example.myapplication
import android.app.Application
import android.os.Bundle
import timber.log.Timber

/**
 * Generates a Pocket dungeon app which allows for generic information throughout the app
 */
class PocketDungeonsApp : Application(){
    /**
    Defines the basic logic to perform when creating the app.
     Set the timber tree where information will be logged into
     */
    override fun onCreate(){
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}