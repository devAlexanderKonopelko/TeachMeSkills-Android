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
    private var flower: Flower? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (flower != null) {
            setViews()
        }
    }

    fun getFlower() = flower

    fun setFlower(flower: Flower?) {
        this.flower = flower
    }

    fun setViews() {
        Picasso.get().load(flower?.url).into(imageFragmentBottom)
        nameBottom.text = flower?.name
        priceBottom.text = flower?.price.toString()
    }
}