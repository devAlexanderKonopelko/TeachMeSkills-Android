package com.example.firstapp.flowers

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.R
import kotlinx.android.synthetic.main.add_flower_layout.*

class AddFlowerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_flower_layout)

        addFlowerToList.setOnClickListener {
            var url: String?
            var name: String?
            var price: Double?

            if (imageUrl.text.isNotEmpty() && editFlowerName.text.isNotEmpty() && editFlowerPrice.text.isNotEmpty()) {
                url = imageUrl.text.toString()
                name = editFlowerName.text.toString()
                price = editFlowerPrice.text.toString().toDouble()

                FlowersList.flowers.flowersList.add(Flower(url, name, price))

                val newToast = Toast.makeText(
                    this,
                    "Flower added",
                    Toast.LENGTH_SHORT
                ).show()

                imageUrl.text.clear()
                editFlowerName.text.clear()
                editFlowerPrice.text.clear()
            } else {
                val newToast =
                    Toast.makeText(this, "Error. Fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
