package com.example.websocketchattest.ui.fragment.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@Module
class MainFragmentModule {
    @Provides
    fun viewModelFactory(mainProvider: Provider<MainViewModel>): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return mainProvider.get() as T
            }

        }
    }
}
