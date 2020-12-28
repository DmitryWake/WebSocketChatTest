package com.example.websocketchattest.application

import android.app.Application
import com.example.websocketchattest.api.Chat
import com.example.websocketchattest.di.dagger.components.AppComponent
import com.example.websocketchattest.di.dagger.components.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        chat = Chat()
    }

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var chat: Chat
    }

}