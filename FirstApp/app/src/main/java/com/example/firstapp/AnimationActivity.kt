package com.example.firstapp

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }

    override fun onStart() {
        super.onStart()
        imageAnimated.apply {
            setBackgroundResource(R.drawable.animation_cat)

            val animation = background as AnimationDrawable
            animation.start()
        }
    }
}
