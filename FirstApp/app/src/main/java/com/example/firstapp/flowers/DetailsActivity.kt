package com.example.firstapp.flowers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.add_flower_layout.*
import kotlinx.android.synthetic.main.details_layout.*
import kotlinx.android.synthetic.main.fragment_top_layout.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)

        val url = intent.getStringExtra("URL")
        val name = intent.getStringExtra("NAME")
        val price = intent.getDoubleExtra("PRICE", 0.0)

        Picasso.get().load(url).into(detailsImage)
        detailsName.text = name
        detailsPrice.text = price.toString()
    }
}
