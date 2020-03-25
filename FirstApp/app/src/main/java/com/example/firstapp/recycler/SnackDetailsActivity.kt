package com.example.firstapp.recycler

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_snack_details.*
import kotlinx.android.synthetic.main.details_layout.*
import kotlinx.android.synthetic.main.recycler_item.view.*

class SnackDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_details)

        Picasso.get().load(intent.getStringExtra("SNACK_IMAGE_URL")).into(snackDetailsImage)
        snackDetailsName.text = intent.getStringExtra("SNACK_NAME")
        snackDetailsPrice.text = intent.getDoubleExtra("SNACK_PRICE", 0.0).toString()
        snackDetailsDescription.text = intent.getStringExtra("SNACK_DESCRIPTION")
    }
}
