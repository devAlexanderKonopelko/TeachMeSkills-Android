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

            val animation = AnimationDrawable()
            animation.isOneShot = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                animation.addFrame(getDrawable(R.drawable.image0)!!, 250)
                animation.addFrame(getDrawable(R.drawable.image1)!!, 250)
                animation.addFrame(getDrawable(R.drawable.image2)!!, 250)
                animation.addFrame(getDrawable(R.drawable.image3)!!, 250)
            }

            this.background = animation
            animation.start()
        }
    }
}
