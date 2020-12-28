package com.example.websocketchattest.api

import io.reactivex.Single
import retrofit2.http.GET

interface ChatApi {
    @GET("/_healthcheck")
    fun healthCheck(): Single<String>

}