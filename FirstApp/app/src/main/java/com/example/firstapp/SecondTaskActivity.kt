package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_task.*

class SecondTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

        flagsButton.setOnClickListener {
            val newIntent = Intent(this, FlagsActivity::class.java)
            startActivity(newIntent)
        }

        animationButton.setOnClickListener {
            val newIntent = Intent(this, AnimationActivity::class.java)
            startActivity(newIntent)
        }
    }
}
