package com.example.demo_phonewalls.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demo_phonewalls.model.Brand
import com.example.demo_phonewalls.model.Picture
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class Resources(val firestore: FirebaseFirestore){
    public fun getAllBrand() : LiveData<List<Brand>>{
        val liveData = MutableLiveData<List<Brand>>();
        firestore.collection("brand")
            .get()
            .addOnSuccessListener { productsSnapshot ->
                val brands = mutableListOf<Brand>()
                for (doc in productsSnapshot.documents) {
                    val id = doc.id
                    val name = doc.getString("name")!!
                    val create_at = doc.getString("create_at")!!
                    val update_at : String? = doc.getString("update_at")
                    brands.add(Brand(id,name,create_at,update_at));
                }
                liveData.postValue(brands)
                Log.d("data", ": ${brands.size}");
            }
            .addOnFailureListener {
            }
        return liveData;
    }

    public fun getAllPicture() : LiveData<List<Picture>>{
        val liveData = MutableLiveData<List<Picture>>();
        firestore.collection("picture")
            .get()
            .addOnSuccessListener { productsSnapshot ->
                val pictures = mutableListOf<Picture>()
                for (doc in productsSnapshot.documents) {
                    val id = doc.id
                    val brand_id = doc.getString("brand_id")!!
                    val name = doc.getString("name")!!
                    val resolution = doc.getString("resolution")!!
                    val url = doc.getString("url")!!
                    val create_at = doc.getString("create_at")!!
                    val update_at : String? = doc.getString("update_at") ?: null
                    pictures.add(Picture(id,brand_id,name,resolution,url,create_at,update_at,null));
                }
                liveData.postValue(pictures)
                Log.d("data", ": ${pictures.size}");
            }
            .addOnFailureListener {
            }
        return liveData;
    }

}