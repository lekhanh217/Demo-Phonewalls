package com.example.demo_phonewalls.ui.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cinemamanagerapp.ui.fragment.FgWallpapers
import com.example.demo_phonewalls.R
import com.example.demo_phonewalls.firebase.Resources
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
class App : AppCompatActivity() {
    val firebase = Firebase.firestore;
    val transaction = supportFragmentManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app)
        this.findViewById<BottomNavigationView>(R.id.bottom_nav).
        setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_fg_wall_papers -> {
                    transaction.replace(R.id.fl_container_fg,FgWallpapers()).commit()
                    true
                }
                R.id.nav_fg_category -> {
                    transaction.replace(R.id.fl_container_fg,FgBrand()).commit()
                    true
                }
                R.id.nav_fav -> {
                    transaction.replace(R.id.fl_container_fg,FgFavorite()).commit()
                    true
                }
                else -> false
            }
        }
//        val imageUrl = "https://i.postimg.cc/LXznzG7q/133555947493208265.jpg"
//        Glide.with(this)
//            .load(imageUrl)
//            .into(imageView)
        Resources(firebase).getAllBrand();
        Resources(firebase).getAllPicture();
    }
}