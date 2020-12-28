package com.example.websocketchattest.ui.fragment.chat

import android.util.Log
import androidx.lifecycle.*
import com.example.websocketchattest.application.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChatViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    private val checkStatusLiveData = MutableLiveData<String>()
    private var checkStatusDisposable: Disposable? = null

    fun initViewModel() {
        checkStatusDisposable?.dispose()
        checkStatusDisposable = App.chat.checkHealth().
        subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe( { t ->
            Log.i(CHAT_VIEW_MODEL_TAG, t)
        }, { e ->
            Log.e(CHAT_VIEW_MODEL_TAG, e.message.toString())
        })
    }

    companion object {
        const val CHAT_VIEW_MODEL_TAG = "ChatViewModel"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        checkStatusDisposable?.dispose()
    }

}
