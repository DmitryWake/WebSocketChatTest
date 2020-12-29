package com.example.websocketchattest.ui.fragment.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.websocketchattest.R
import com.example.websocketchattest.api.model.ClientModel
import com.example.websocketchattest.ui.activity.MainActivity

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var component: MainFragmentSubcomponent

    private lateinit var configTextView: TextView
    private lateinit var clientIdTextView: TextView
    private lateinit var messageEditEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component =
            (activity as MainActivity).appComponent().getMainActivitySubComponent().chatComponent()
        viewModel =
            ViewModelProviders.of(this, component.viewModelFactory()).get(MainViewModel::class.java)
        viewModel.initViewModel()
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        messageEditEditText = view.findViewById(R.id.fragment_main_et_message_text)
        viewModel.apply {
            checkStatusLiveData.observe({viewLifecycleOwner.lifecycle}, ::showStatus)
            configStringLiveData.observe({viewLifecycleOwner.lifecycle}, ::showConfig)
            clientLiveData.observe({viewLifecycleOwner.lifecycle}, ::showId)
        }
        view.findViewById<Button>(R.id.fragment_main_btn_create_config).setOnClickListener {
            viewModel.createDefaultConfig()
        }
        view.findViewById<Button>(R.id.fragment_main_btn_get_config).setOnClickListener {
            viewModel.getDefaultConfig()
        }
        view.findViewById<Button>(R.id.fragment_main_btn_create_client).setOnClickListener {
            viewModel.createClient()
        }
        view.findViewById<Button>(R.id.fragment_main_btn_start_chat).setOnClickListener {
            viewModel.startChat()
        }
        view.findViewById<ImageButton>(R.id.fragment_main_btn_send_message).setOnClickListener {
            if (!messageEditEditText.text.isNullOrEmpty()) {
                viewModel.sendMessage(messageEditEditText.text.toString())
            }
        }
        configTextView = view.findViewById(R.id.fragment_main_tv_config)
        clientIdTextView = view.findViewById(R.id.fragment_main_tv_client)
        return view
    }

    @SuppressLint("SetTextI18n")
    private fun showId(clientModel: ClientModel?) {
        if (clientModel != null) {
            clientIdTextView.text = "id: ${clientModel.id}"
        }
    }

    private fun showConfig(configString: String?) {
        configTextView.text = configString
    }

    @SuppressLint("ShowToast")
    private fun showStatus(status: String?) {
        Toast.makeText(context, "status: $status", Toast.LENGTH_SHORT).show()
    }
}
