package com.example.e06myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewMessage: TextView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewMessage = findViewById(R.id.textViewMessage)
        buttonBack = findViewById(R.id.buttonBack)

        val intent = intent
        if (intent.hasExtra("message")) {
            val message = intent.getStringExtra("message")
            textViewMessage.text = message
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}