package com.example.websocketchattest.ui.fragment.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@Module
class ChatModule {
    @Provides
    fun viewModelFactory(chatProvider: Provider<ChatViewModel>): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return chatProvider.get() as T
            }

        }
    }
}
