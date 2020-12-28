package com.example.websocketchattest.di.dagger.components

import com.example.websocketchattest.di.dagger.components.scope.ActivityScope
import com.example.websocketchattest.ui.fragment.chat.ChatFragmentSubcomponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainActivitySubcomponent {
    fun chatComponent(): ChatFragmentSubcomponent
}
