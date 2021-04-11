package com.example.cm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.notasButton)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, NotasActivity::class.java)
            startActivity(intent)
        }
    }
}