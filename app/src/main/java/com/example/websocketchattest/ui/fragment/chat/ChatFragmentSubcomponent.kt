package com.example.websocketchattest.ui.fragment.chat

import androidx.lifecycle.ViewModelProvider
import com.example.websocketchattest.di.dagger.components.scope.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ChatModule::class])
interface ChatFragmentSubcomponent {
    fun viewModelFactory(): ViewModelProvider.Factory
}
