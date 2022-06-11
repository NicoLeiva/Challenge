package com.example.challenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Color(
    val hex: String,
    val name: String
) : Parcelable