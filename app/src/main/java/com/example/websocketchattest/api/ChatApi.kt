package com.example.websocketchattest.api

import com.example.websocketchattest.api.model.ClientModel
import com.example.websocketchattest.api.model.ConfigModel
import com.example.websocketchattest.api.request.CreateClientRequest
import com.example.websocketchattest.api.request.PublishRequest
import com.example.websocketchattest.api.response.StatusResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface ChatApi {
    @GET("_healthcheck")
    fun healthCheck(): Single<StatusResponse>

    @POST("api/config")
    @Headers(
        "Content-Type: application/json",
        "X-AUTH-TOKEN: ${ApiService.X_AUTH_TOKEN}"
    )
    fun createConfig(@Body configModel: ConfigModel): Single<ResponseBody>

    @GET("api/config/{app_name}")
    @Headers(
        "Content-Type: application/json",
        "X-AUTH-TOKEN: ${ApiService.X_AUTH_TOKEN}"
    )
    fun getConfig(@Path("app_name") appName: String): Single<ConfigModel>

    @POST("api/channel")
    @Headers(
        "Content-Type: application/json",
        "X-AUTH-TOKEN: ${ApiService.X_AUTH_TOKEN}"
    )
    fun createBaseChannel(@Body channelRequest: ChannelRequest): Single<ResponseBody>

    @POST("api/client")
    @Headers(
        "Content-Type: application/json",
        "X-AUTH-TOKEN: ${ApiService.X_AUTH_TOKEN}"
    )
    fun createClient(@Body createClientRequest: CreateClientRequest): Single<ClientModel>

    @POST("api/publish")
    @Headers(
        "Content-Type: application/json",
        "X-AUTH-TOKEN: ${ApiService.X_AUTH_TOKEN}"
    )
    fun publishMessage(@Body publishRequest: PublishRequest): Single<ResponseBody>

}