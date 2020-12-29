package com.example.websocketchattest.api

import android.util.Log
import android.widget.TextView
import com.example.websocketchattest.api.model.ClientModel
import com.example.websocketchattest.api.model.ConfigModel
import com.example.websocketchattest.api.model.MessageModel
import com.example.websocketchattest.api.request.CreateClientRequest
import com.example.websocketchattest.api.request.PublishRequest
import com.example.websocketchattest.application.App
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.ResponseBody
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI
import javax.net.SocketFactory
import javax.net.ssl.SSLSocketFactory

class ApiService {

    private val api: ChatApi = App.appComponent.getChatApi()

    private lateinit var webSocketClient: WebSocketClient

    companion object {
        const val BASE_URL = "http://messenger.kc:8080/"
        const val WEB_SOCKET_URL = "ws://messenger.kc:8080/ws"
        const val X_AUTH_TOKEN = "sWUhHRcs4Aqa0MEnYwbuQln3EW8CZ0oD"
        const val TAG = "ApiService"
    }

    fun checkHealth(): Single<String> {
        return api.healthCheck().map {
            it.status
        }
    }

    fun createConfig(appName: String, value: String = "Beaver"): Single<String> {
        val config = ConfigModel(appName, value)
        return api.createConfig(config).map {
            it.toString()
        }
    }

    fun getConfig(appName: String): Single<ConfigModel> {
        return api.getConfig(appName)
    }

    fun createBaseChannel(): Single<ResponseBody> {
        val channelRequest = ChannelRequest("base_channel")
        return api.createBaseChannel(channelRequest)
    }

    fun createClient(): Single<ClientModel> {
        val channelsArrayList = arrayListOf("base_channel")
        val createClientRequest = CreateClientRequest(channelsArrayList)
        return api.createClient(createClientRequest)
    }

    fun publishMessage(message: String): Single<ResponseBody> {
        val messageModel = MessageModel(message)
        val requestModel = PublishRequest("base_channel", Gson().toJson(messageModel))
        return api.publishMessage(requestModel)
    }

    fun initWebSocket(clientId: String, clientToken: String) {
        Log.i(TAG, "Trying to connect")
        val socketFactory = SocketFactory.getDefault() as SocketFactory

        webSocketClient = object : WebSocketClient(URI("$WEB_SOCKET_URL/$clientId/$clientToken")) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Log.i(TAG, "Open")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Log.i(TAG, reason.toString())
            }

            override fun onMessage(message: String?) {
                message?.let { Log.i(TAG, it) }
            }

            override fun onError(ex: Exception?) {
                Log.e(TAG, ex?.message.toString())
            }
        }

        webSocketClient.setSocketFactory(socketFactory)
        webSocketClient.connect()

    }

    fun killWebSocket() {
        webSocketClient.close()
    }

}