package com.example.websocketchattest.application

import android.app.Application
import com.example.websocketchattest.api.ApiService
import com.example.websocketchattest.di.dagger.components.AppComponent
import com.example.websocketchattest.di.dagger.components.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        apiService = ApiService()
    }

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var apiService: ApiService
    }

}