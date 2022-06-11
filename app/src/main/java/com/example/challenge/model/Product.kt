package com.example.challenge.model

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("id") var id:String?,
    @SerializedName("mainImage") var mainImage:String?,
    @SerializedName("name") var name: String?,
    @SerializedName("installmentsTags") var installmentsTags:String?,
    @SerializedName("topTag") var topTag:String
)