package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button_1.setOnClickListener {
            val newIntent = Intent(this, FirstTaskActivity::class.java)
            startActivity(newIntent)
        }

        main_button_2.setOnClickListener {
            val newIntent = Intent(this, SecondTaskActivity::class.java)
            startActivity(newIntent)
        }

        main_button_3.setOnClickListener {
            val newIntent = Intent(this, MainCoronavirusActivity::class.java)
            startActivity(newIntent)
        }
        main_button_4.setOnClickListener {
            val newIntent = Intent(this, com.example.firstapp.flowers.MainActivityFlowers::class.java)
            startActivity(newIntent)
        }
    }
}
