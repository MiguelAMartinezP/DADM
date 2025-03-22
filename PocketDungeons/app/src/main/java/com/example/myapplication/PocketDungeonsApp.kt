package com.example.myapplication
import android.app.Application
import android.os.Bundle
import timber.log.Timber

class PocketDungeonsApp : Application(){
    override fun onCreate(){
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}