package com.example.firstapp.flowers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_top_layout.*

class FragmentTop: Fragment() {
    private var flower: Flower? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (flower != null) {
            setViews()
        }
    }

    fun setFlower(flower: Flower?) {
        this.flower = flower
    }
    fun getFlower() = flower

    fun setViews() {
        Picasso.get().load(flower?.url).into(imageFragmentTop)
        nameTop.text = flower?.name
        priceTop.text = flower?.price.toString()
    }

}