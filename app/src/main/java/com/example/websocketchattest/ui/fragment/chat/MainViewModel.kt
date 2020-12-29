package com.example.websocketchattest.ui.fragment.chat

import android.util.Log
import androidx.lifecycle.*
import com.example.websocketchattest.api.model.ClientModel
import com.example.websocketchattest.application.App
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.security.auth.login.LoginException

class MainViewModel @Inject constructor() : ViewModel(), LifecycleObserver {

    val checkStatusLiveData = MutableLiveData<String>()
    val configStringLiveData = MutableLiveData<String>()
    val clientLiveData = MutableLiveData<ClientModel>()

    private var sendMessageDisposable: Disposable? = null
    private var createClientDisposable: Disposable? = null
    private var getConfigDisposable: Disposable? = null
    private var createConfigDisposable: Disposable? = null
    private var checkStatusDisposable: Disposable? = null

    fun initViewModel() {
        checkStatusDisposable?.dispose()
        checkStatusDisposable = App.apiService.checkHealth().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
                checkStatusLiveData.value = t
            }, { e ->
                Log.e(CHAT_VIEW_MODEL_TAG, e.message.toString())
            })
    }

    fun createDefaultConfig() {
        createConfigDisposable?.dispose()
        createConfigDisposable = App.apiService.createConfig("websocketchat")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                Log.i(CHAT_VIEW_MODEL_TAG, t)
            }, { e ->
                Log.e(CHAT_VIEW_MODEL_TAG, e.message.toString())
            })
    }

    fun getDefaultConfig() {
        getConfigDisposable?.dispose()
        getConfigDisposable = App.apiService.getConfig("websocketchat")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                configStringLiveData.value = "key: ${t.key}\nvalue: ${t.value}"
            }, { e ->
                Log.e(CHAT_VIEW_MODEL_TAG, e.message.toString())
            })
    }

    fun createClient() {
        createClientDisposable?.dispose()
        createClientDisposable = App.apiService.createClient()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                clientLiveData.value = t
            }, { e ->
                Log.e(CHAT_VIEW_MODEL_TAG, e.message.toString())
            })
    }

    fun sendMessage(message: String) {
        sendMessageDisposable?.dispose()
        sendMessageDisposable = App.apiService.publishMessage(message)
            .subscribeOn(Schedulers.io())
            .subscribe({
            }, {
                Log.e(CHAT_VIEW_MODEL_TAG, it.message.toString())
            })
    }

    fun startChat() {
        if (clientLiveData.value != null) {
            Single.fromCallable {
                App.apiService.initWebSocket(
                    clientLiveData.value!!.id,
                    clientLiveData.value!!.token
                )
            }.subscribeOn(Schedulers.io()).subscribe()
        } else {
            Log.e(CHAT_VIEW_MODEL_TAG, "Client is not auth")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        sendMessageDisposable?.dispose()
        checkStatusDisposable?.dispose()
        createClientDisposable?.dispose()
        createConfigDisposable?.dispose()
        getConfigDisposable?.dispose()
        App.apiService.killWebSocket()
    }

    companion object {
        const val CHAT_VIEW_MODEL_TAG = "ChatViewModel"
    }
}
