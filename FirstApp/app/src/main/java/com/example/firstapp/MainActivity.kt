package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.flowers.MainFlowerActivity
import com.example.firstapp.networking.MainNetworkingActivity
import com.example.firstapp.recycler.MainRecyclerActivity
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
            val newIntent = Intent(this, MainFlowerActivity::class.java)
            startActivity(newIntent)
        }
        main_button_5.setOnClickListener {
            val newIntent = Intent(this, MainRecyclerActivity::class.java)
            startActivity(newIntent)
        }

        main_button_6.setOnClickListener {
            startActivity(Intent(this, MainDatabaseActivity::class.java))
        }

        main_button_7.setOnClickListener {
            startActivity(Intent(this, MainNetworkingActivity::class.java))
        }

        main_button_9.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}
