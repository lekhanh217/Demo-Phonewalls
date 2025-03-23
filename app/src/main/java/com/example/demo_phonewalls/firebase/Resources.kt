package com.example.demo_phonewalls.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demo_phonewalls.model.Brand
import com.example.demo_phonewalls.model.Color
import com.example.demo_phonewalls.model.Picture
import com.google.firebase.firestore.FirebaseFirestore
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
                var addedElement = 0;
                for (doc in productsSnapshot.documents) {
                    val picture_id = doc.id
                    val brand_id = doc.getString("brand_id")!!
                    val name = doc.getString("name")!!
                    val resolution = doc.getString("resolution")!!
                    val url = doc.getString("url")!!
                    val picture_create_at = doc.getString("create_at")!!
                    val picture_update_at : String? = doc.getString("update_at") ?: null;
                    firestore.collection("color")
                        .whereEqualTo("picture_id", picture_id)
                        .get()
                        .addOnSuccessListener { querySnapshot ->
                            val colors = mutableListOf<Color>()
                            for (doc in querySnapshot.documents) {
                                val color_id = doc.id
                                val hex_code = doc.getString("hex_code")!!
                                val color_create_at = doc.getString("create_at")!!
                                val color_update_at : String? = doc.getString("update_at") ?: null;
                                colors.add(Color(color_id,picture_id,hex_code,color_create_at,color_update_at));
                            }
                            pictures.add(Picture(picture_id,brand_id,name,resolution,url,picture_create_at,picture_update_at,colors));
                            addedElement++
                            if(addedElement == productsSnapshot.documents.size) {
                                liveData.postValue(pictures)
                                Log.d("size picture", ": ${pictures.size}");
                                Log.d("first picture element", ": ${pictures.get(0).toString()}");
                            }
                         }
                        .addOnFailureListener { e ->
                        }
                }
            }
            .addOnFailureListener {
            }
        return liveData;
    }
}