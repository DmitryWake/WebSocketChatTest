package com.example.websocketchattest.api

import com.example.websocketchattest.api.response.StatusResponse
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.http.GET

interface ChatApi {
    @GET("/_healthcheck")
    fun healthCheck(): Single<StatusResponse>

}