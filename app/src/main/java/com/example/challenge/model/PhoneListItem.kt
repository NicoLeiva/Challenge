package com.example.challenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhoneListItem(
    val id: String,
    val images: List<Image>,
    val installmentsTag: String,
    val legal: String,
    val name: String,
    val topTag: String,
    val mainImage: MainImage,
): Parcelable {
    constructor() : this("", listOf(), "","","","",MainImage())

}