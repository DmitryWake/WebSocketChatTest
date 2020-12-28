package com.example.websocketchattest.di.dagger.components

import com.example.websocketchattest.api.ApiModule
import com.example.websocketchattest.api.ChatApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiModule::class])
@Singleton
interface AppComponent {
    fun getChatApi(): ChatApi
    fun getMainActivitySubComponent(): MainActivitySubcomponent
}
