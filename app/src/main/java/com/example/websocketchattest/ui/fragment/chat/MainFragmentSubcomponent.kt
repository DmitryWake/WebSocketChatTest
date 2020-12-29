package com.example.websocketchattest.ui.fragment.chat

import androidx.lifecycle.ViewModelProvider
import com.example.websocketchattest.di.dagger.components.scope.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentSubcomponent {
    fun viewModelFactory(): ViewModelProvider.Factory
}
