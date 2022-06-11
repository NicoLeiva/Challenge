package com.example.challenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainImage(
    val alternativeText: String,
    val caption: String,
    val height: Int,
    val thumbnailUrl: String,
    val url: String,
    val width: Int
) : Parcelable{

}