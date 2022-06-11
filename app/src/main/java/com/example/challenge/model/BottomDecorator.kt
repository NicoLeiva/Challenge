package com.example.challenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BottomDecorator(
    val alternativeText: String,
    val caption: String,
    val thumbnailUrl: String,
    val url: String
): Parcelable