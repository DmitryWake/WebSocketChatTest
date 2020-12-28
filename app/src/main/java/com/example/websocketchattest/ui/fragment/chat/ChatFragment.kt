package com.example.websocketchattest.ui.fragment.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.websocketchattest.ui.activity.MainActivity

class ChatFragment : Fragment() {
    private lateinit var viewModel: ChatViewModel
    private lateinit var component: ChatFragmentSubcomponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component =
            (activity as MainActivity).appComponent().getMainActivitySubComponent().chatComponent()
        viewModel =
            ViewModelProviders.of(this, component.viewModelFactory()).get(ChatViewModel::class.java)
        viewModel.initViewModel()
        lifecycle.addObserver(viewModel)
    }
}
