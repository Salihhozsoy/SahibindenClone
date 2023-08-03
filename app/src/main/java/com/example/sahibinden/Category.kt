package com.example.sahibinden

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(val id:Int, val categoryPic:String, val categoryName:String, val categoryText:String,val AdvertTitle:String) :
    Parcelable
