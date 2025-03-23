package com.example.demo_phonewalls

import android.graphics.Matrix
import android.graphics.PointF
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.demo_phonewalls.firebase.Resources
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    val firebase = Firebase.firestore;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageview)
        val imageUrl = "https://i.postimg.cc/LXznzG7q/133555947493208265.jpg"
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)
        Resources(firebase).getAllBrand();
        Resources(firebase).getAllPicture();
    }
}