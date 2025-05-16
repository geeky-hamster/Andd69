package com.example.animationdemo

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnAnimate = findViewById<Button>(R.id.btnAnimate)

        btnAnimate.setOnClickListener {
            val animation = AlphaAnimation(0.0f, 1.0f)
            animation.duration = 1000
            imageView.startAnimation(animation)
        }
    }
}
