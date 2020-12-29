package com.example.websocketchattest.api

import com.example.websocketchattest.application.App
import io.reactivex.Single

class Chat() {

    private val api: ChatApi = App.appComponent.getChatApi()


    // TODO Ввести нужный токен и url
    companion object {
        const val BASE_URL = "http://messenger.kc:8080"
        const val TOKEN = "token"
    }

    fun checkHealth(): Single<String> {
        return api.healthCheck().map {
            it.status
        }
    }

}