package com.example.e05launchamap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMap(view: View) {

        val latEditText = findViewById<EditText>(R.id.latEditText)
        val lngEditText = findViewById<EditText>(R.id.lngEditText)

        val latitude = latEditText.text.toString()
        val longitude = lngEditText.text.toString()

        val locationUri = Uri.parse("geo:$latitude,$longitude")

        val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)

        startActivity(mapIntent)
    }


}







