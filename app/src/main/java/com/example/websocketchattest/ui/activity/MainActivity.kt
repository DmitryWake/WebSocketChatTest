package com.example.websocketchattest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.websocketchattest.R
import com.example.websocketchattest.application.App
import com.example.websocketchattest.ui.fragment.chat.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                MainFragment()
            )
            .commit()
    }

    fun appComponent() = App.appComponent
}
