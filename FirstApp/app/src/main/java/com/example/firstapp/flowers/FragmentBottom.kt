package com.example.firstapp.flowers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_bottom_layout.*

class FragmentBottom: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (FlowersList.flowers.flowersList.size > 0) {
            setViews()
        }
    }

    private fun setViews() {
        val flower = FlowersList.flowers.flowersList[1]

        Picasso.get().load(flower.url).into(imageFragmentBottom)
        nameBottom.text = flower.name
        priceBottom.text = flower.price.toString()
    }
}