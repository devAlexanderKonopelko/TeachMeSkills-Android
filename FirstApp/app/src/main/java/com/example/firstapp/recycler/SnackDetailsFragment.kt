package com.example.firstapp.recycler

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_recycler.*
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.snack_details_fragment.*

class SnackDetailsFragment() : Fragment() {
    var position = 0
    constructor(position: Int) : this() {
        this.position = position
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.snack_details_fragment,container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val snack = SnackCollection.instance.snackCollection.get(position)

            Picasso.get().load(snack.imageUrl).into(snackDetailsFragmentImage)
            snackDetailsFragmentName.text = snack.name
            snackDetailsFragmentPrice.text = snack.price.toString()
            snackDetailsFragmentDescription.text = snack.description
        }
    }
}