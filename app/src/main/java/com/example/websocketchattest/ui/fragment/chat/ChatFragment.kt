package com.example.websocketchattest.ui.fragment.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.websocketchattest.R
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        viewModel.apply {
            checkStatusLiveData.observe({viewLifecycleOwner.lifecycle}, ::showStatus)
        }
        return view
    }

    @SuppressLint("ShowToast")
    private fun showStatus(status: String?) {
        Toast.makeText(context, "status: $status", Toast.LENGTH_SHORT).show()
    }
}
