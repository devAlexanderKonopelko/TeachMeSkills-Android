package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButton = main_button_1
        mainButton.setOnClickListener {
            val newIntent = Intent(this, FirstTaskActivity::class.java)
            startActivity(newIntent)
        }
    }
}
