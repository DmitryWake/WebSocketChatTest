package com.example.websocketchattest.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.websocketchattest.R
import com.example.websocketchattest.application.App
import com.example.websocketchattest.ui.fragment.chat.ChatFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                ChatFragment()
            )
            .commit()
    }

    fun appComponent() = App.appComponent
}
